package com.kevin.yigroup;

import it.sephiroth.android.library.widget.HListView;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.StringRequest;
import com.kevin.yigroup.config.URLS;
import com.kevin.yigroup.entity.Cinema;
import com.kevin.yigroup.entity.MovieFirst;
import com.kevin.yigroup.entity.MoviePager;
import com.kevin.yigroup.utils.CustomRequest;
import com.kevin.yigroup.utils.JsonParser;
import com.kevin.yigroup.utils.UrlFormat;
import com.kevin.yigroup.view.StartView;

public class MovieDetailsListActivity extends ActionBarActivity implements
		OnClickListener {

	private YiGroupApplication mApplication;
	private RequestQueue mRequestQueue;
	private ImageLoader mImageLoader;
	private ListView mMoveListView;
	private HListView mHListView;
	private RadioGroup mMenuGroup;
	private LinearLayout mListMenu;
	private ListView mLeftMenu;
	private ListView mRightMenu;
	private View mMenuBg;

	private ArrayList<MovieFirst> mMovieFirsts;
	private ArrayList<Cinema> mCinemas;
	private MoveAdapter mMoveAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_goods_details_list);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setTitle("µÁ”∞");
		actionBar.setDisplayHomeAsUpEnabled(true);

		mApplication = (YiGroupApplication) getApplication();
		mRequestQueue = mApplication.getRequestQueue();
		mImageLoader = new ImageLoader(mRequestQueue,
				mApplication.getBitmapCache());

		initUI();
		loadData();
	}

	private void initUI() {

		// fetch menu
		mMenuGroup = (RadioGroup) findViewById(R.id.shops_menu);
		for (int i = 0; i < mMenuGroup.getChildCount(); i++) {
			View view = mMenuGroup.getChildAt(i);
			if (view instanceof RadioButton) {
				view.setOnClickListener(this);
			}
		}

		mListMenu = (LinearLayout) findViewById(R.id.list_menu);
		mLeftMenu = (ListView) findViewById(R.id.left_choice_zone);
		mRightMenu = (ListView) findViewById(R.id.right_choice_zone);
		mMenuBg = findViewById(R.id.menu_bg);

		mMoveListView = (ListView) findViewById(R.id.movie_list);
		View view = getLayoutInflater().inflate(R.layout.movie_header,
				mMoveListView, false);
		mHListView = (HListView) view.findViewById(R.id.h_list_view);
		View footer = getLayoutInflater().inflate(R.layout.movie_footer,
				mHListView, false);
		View locationView = getLayoutInflater().inflate(R.layout.location_item,
				mMoveListView, false);
		mHListView.addFooterView(footer);
		mMoveListView.addHeaderView(locationView);
		mMoveListView.addHeaderView(view);
		mMoveListView.setDivider(null);
		mMoveListView.setVerticalScrollBarEnabled(false);
		mMoveListView.setAdapter(mMoveAdapter = new MoveAdapter());

	}

	private void loadData() {

		CustomRequest request = new CustomRequest(Method.POST, URLS.MOVES_URL,
				URLS.MOVES_BODY, new Listener<String>() {

					@Override
					public void onResponse(String response) {

						if (response != null) {
							mMovieFirsts = JsonParser.getMoviewFirsts(response);
							if (mMovieFirsts != null) {
								mHListView.setAdapter(new MoveHeaderAdapter());
							}
						}

					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {

					}
				});
		request.setShouldCache(false);
		mRequestQueue.add(request);

		mRequestQueue.add(new StringRequest(URLS.MOVES_LIST_URL,
				new Listener<String>() {

					@Override
					public void onResponse(String response) {

						if (response != null && !response.isEmpty()) {
							MoviePager pager = JsonParser.getParsedData(
									response, MoviePager.class);
							if (pager != null) {
								mCinemas = pager.getData();
								mMoveAdapter.bindData(mCinemas);
								mMoveAdapter.notifyDataSetChanged();
							}
						}

					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {

					}
				}));

	}

	class MoveHeaderAdapter extends BaseAdapter {

		class ViewHolder {
			TextView tv;
			ImageView img;
		}

		@Override
		public int getCount() {
			return mMovieFirsts.size();
		}

		@Override
		public Object getItem(int position) {
			return mMovieFirsts.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			ViewHolder viewHolder = null;
			if (convertView == null) {

				viewHolder = new ViewHolder();
				convertView = getLayoutInflater().inflate(
						R.layout.move_header_item, parent, false);
				viewHolder.tv = (TextView) convertView.findViewById(R.id.title);
				viewHolder.img = (ImageView) convertView.findViewById(R.id.img);
				convertView.setTag(viewHolder);
			}

			viewHolder = (ViewHolder) convertView.getTag();
			MovieFirst movieFirst = mMovieFirsts.get(position);
			viewHolder.tv.setText(movieFirst.getNm());
			ImageListener listener = ImageLoader.getImageListener(
					viewHolder.img, R.drawable.ic_launcher,
					R.drawable.ic_launcher);
			mImageLoader.get(UrlFormat.formatGYLImgUrl(movieFirst.getImg()),
					listener);
			return convertView;
		}

	}

	class MoveAdapter extends BaseAdapter {

		private ArrayList<Cinema> cinemas = new ArrayList<Cinema>();

		class ViewHolder {
			private TextView cinemaNameTv;
			private ImageView locationIv;
			private ImageView hgroupIv;
			private StartView startView;
			private TextView preferentialTv;
			private ImageView isPreferentialIv;
			private TextView priceTv;
			private TextView addressTv;
		}

		public void bindData(ArrayList<Cinema> cinemas) {

			if (cinemas != null) {
				this.cinemas = cinemas;
			}
		}

		@Override
		public int getCount() {
			return cinemas.size();
		}

		@Override
		public Object getItem(int position) {
			return cinemas.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			TextView tv = null;
			ViewHolder viewHolder = null;

			if (convertView == null) {
				convertView = LayoutInflater.from(parent.getContext()).inflate(
						R.layout.cinema_item, parent, false);
				viewHolder = new ViewHolder();
				viewHolder.cinemaNameTv = (TextView) convertView
						.findViewById(R.id.cinema_name);
				viewHolder.addressTv = (TextView) convertView
						.findViewById(R.id.address);
				viewHolder.hgroupIv = (ImageView) convertView
						.findViewById(R.id.has_group);
				viewHolder.isPreferentialIv = (ImageView) convertView
						.findViewById(R.id.is_preferential);
				viewHolder.locationIv = (ImageView) convertView
						.findViewById(R.id.has_location);
				viewHolder.priceTv = (TextView) convertView
						.findViewById(R.id.price);
				viewHolder.startView = (StartView) convertView
						.findViewById(R.id.start_count);
				viewHolder.preferentialTv = (TextView) convertView
						.findViewById(R.id.preferential);
				convertView.setTag(viewHolder);
			}

			viewHolder = (ViewHolder) convertView.getTag();
			Cinema cinema = cinemas.get(position);

			viewHolder.cinemaNameTv.setText(cinema.getName());
			viewHolder.startView.setAvgScore(cinema.getAvgScore());
			viewHolder.addressTv.setText(cinema.getAreaName());
			viewHolder.priceTv.setText("£§" + cinema.getAvgPrice() + "");
			viewHolder.locationIv
					.setVisibility(cinema.isChooseSitting() ? View.VISIBLE
							: View.GONE);
			viewHolder.hgroupIv
					.setVisibility(cinema.isHasGroup() ? View.VISIBLE
							: View.GONE);
			viewHolder.isPreferentialIv
					.setVisibility(cinema.isPreferent() ? View.VISIBLE
							: View.GONE);

			return convertView;
		}

	}

	private void switchVisiblity() {

		if (mListMenu.getVisibility() == View.VISIBLE) {
			mListMenu.setVisibility(View.GONE);
		} else {
			mListMenu.setVisibility(View.VISIBLE);
		}

		if (mMenuBg.getVisibility() == View.VISIBLE) {
			mMenuBg.setVisibility(View.GONE);
		} else {
			mMenuBg.setVisibility(View.VISIBLE);
		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.all_catalogue:
			break;
		case R.id.choice_zone:
			break;
		case R.id.order_type:
			break;
		case R.id.choice:
			break;

		default:
			break;
		}

		switchVisiblity();
	}
}

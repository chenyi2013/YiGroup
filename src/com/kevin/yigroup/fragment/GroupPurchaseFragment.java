package com.kevin.yigroup.fragment;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.StringRequest;
import com.kevin.yigroup.R;
import com.kevin.yigroup.YiGroupApplication;
import com.kevin.yigroup.config.URLS;
import com.kevin.yigroup.entity.Deal;
import com.kevin.yigroup.entity.DealInfo;
import com.kevin.yigroup.entity.Favorable;
import com.kevin.yigroup.entity.FavorableInfo;
import com.kevin.yigroup.entity.Info;
import com.kevin.yigroup.entity.MeiTuanFood;
import com.kevin.yigroup.entity.Morepage;
import com.kevin.yigroup.entity.StidData;
import com.kevin.yigroup.entity.StidInfo;
import com.kevin.yigroup.utils.CustomRequest;
import com.kevin.yigroup.utils.DisplayUtils;
import com.kevin.yigroup.utils.JsonParser;
import com.kevin.yigroup.utils.UrlFormat;
import com.kevin.yigroup.view.MyGridView;

public class GroupPurchaseFragment extends Fragment implements
		OnCheckedChangeListener, OnDismissListener {

	private static final String TAG = "GroupPurchaseFragment";

	private CheckBox mCurrentCity;
	private DisplayUtils mDisplayUtils;
	private PopupWindow mPopupWindow;

	private GridView mSubCityGridView;
	private MyGridView mGoodsType;
	private MyGridView mSnapUpGridView;
	private MyGridView mFavorableGridView;
	private ListView mListView;
	private ImageView mMeiTuanFoodImg;
	private TextView mMeiTuanFoodTitle;
	private TextView mMeiTuanFoodDesc;

	private GoodsTypeAdapter mGoodsAdapter;
	private GuessYouLikeAdapter mGuessYouLikeAdapter;
	private RequestQueue mQueue;
	private ImageLoader mImageLoader = null;
	private YiGroupApplication mApplication;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mDisplayUtils = new DisplayUtils(getActivity());
		mApplication = (YiGroupApplication) getActivity().getApplication();
		mQueue = mApplication.getRequestQueue();
		mImageLoader = new ImageLoader(mQueue, mApplication.getBitmapCache());

	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_group_purchase, container,
				false);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initView();
		initCityMenu();
		loadData();
	}

	@SuppressLint("InflateParams")
	private void initView() {

		mCurrentCity = (CheckBox) getView().findViewById(R.id.current_city);
		mCurrentCity.setOnCheckedChangeListener(this);
		mListView = (ListView) getView().findViewById(R.id.list);
		mListView.setDivider(null);
		View header = LayoutInflater.from(getActivity()).inflate(
				R.layout.group_purchase_list_header, mListView, false);
		View footer = LayoutInflater.from(getActivity()).inflate(
				R.layout.group_purchase_list_footer, mListView, false);

		LinearLayout meiTuanFoodLayout = (LinearLayout) header
				.findViewById(R.id.mei_tuan_foot_layout);
		mMeiTuanFoodTitle = (TextView) meiTuanFoodLayout
				.findViewById(R.id.title);
		mMeiTuanFoodDesc = (TextView) meiTuanFoodLayout.findViewById(R.id.dec);
		mMeiTuanFoodImg = (ImageView) meiTuanFoodLayout
				.findViewById(R.id.meituan_bood_img);

		mGoodsType = (MyGridView) header.findViewById(R.id.goods_type_grid);
		mSnapUpGridView = (MyGridView) header
				.findViewById(R.id.snap_up_grid_view);
		mFavorableGridView = (MyGridView) header
				.findViewById(R.id.favorable_grid_view);
		mListView.addHeaderView(header);
		mListView.addFooterView(footer);

	}

	@SuppressLint("InflateParams")
	public void initCityMenu() {

		LinearLayout layout = (LinearLayout) LayoutInflater.from(getActivity())
				.inflate(R.layout.current_city_sub_city, null);
		ColorDrawable colorDrawable = new ColorDrawable(0xffffffff);
		mSubCityGridView = (GridView) layout
				.findViewById(R.id.sub_city_grid_view);
		mSubCityGridView.setAdapter(new CityAdapter());

		mPopupWindow = new PopupWindow(getActivity());
		mPopupWindow.setWidth(mDisplayUtils.getDisplayWidth());
		mPopupWindow.setHeight(mDisplayUtils.getDisplayHeight() / 2);
		mPopupWindow.setBackgroundDrawable(colorDrawable);
		mPopupWindow.setFocusable(true);
		mPopupWindow.setOutsideTouchable(true);
		mPopupWindow.setContentView(layout);
		mPopupWindow.setOnDismissListener(this);

	}

	public void loadData() {

		mQueue.add(new StringRequest(URLS.GOOD_TYPE_URL,
				new Listener<String>() {

					@Override
					public void onResponse(String json) {

						mGoodsAdapter = new GoodsTypeAdapter();
						mGoodsAdapter.bindData(JsonParser
								.getParsedData(json, Info.class).getData()
								.getHomepage());
						mGoodsType.setAdapter(mGoodsAdapter);
						mGoodsAdapter.notifyDataSetChanged();

					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						Log.e(TAG, "request network error", error);
					}
				}));

		mQueue.add(new StringRequest(URLS.SNAP_UP_URL, new Listener<String>() {

			@Override
			public void onResponse(String json) {

				SnapUpAdapter adapter = new SnapUpAdapter();
				adapter.bindData(JsonParser.getParsedData(json, DealInfo.class)
						.getData().getDeals());
				mSnapUpGridView.setAdapter(adapter);

			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				Log.e(TAG, "request network error", error);
			}
		}));

		mQueue.add(new StringRequest(URLS.FAVORABLE_URL,
				new Listener<String>() {

					@Override
					public void onResponse(String json) {

						FavorableAdapter adapter = new FavorableAdapter();
						adapter.bindData(JsonParser.getParsedData(json,
								FavorableInfo.class).getData());
						mFavorableGridView.setAdapter(adapter);

					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						Log.e(TAG, "request network error", error);
					}
				}));

		mQueue.add(new StringRequest(URLS.MEITUAN_FOOD_URL,
				new Listener<String>() {

					@Override
					public void onResponse(String json) {

						MeiTuanFood food = JsonParser.getMeiTuanFood(json);
						mMeiTuanFoodTitle.setText(food.getTitle());
						mMeiTuanFoodDesc.setText(food.getComment());
						ImageListener listener = ImageLoader.getImageListener(
								mMeiTuanFoodImg, R.drawable.ic_launcher,
								R.drawable.ic_launcher);
						mImageLoader.get(food.getImageUrl(), listener);

					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						Log.e(TAG, "request network error", error);
					}
				}));

		CustomRequest request = new CustomRequest(Method.POST,
				URLS.GUESS_YOU_LIKE_URL, URLS.GUESS_YOU_LIKE_PARAM,
				new Listener<String>() {

					@Override
					public void onResponse(String json) {
						mGuessYouLikeAdapter = new GuessYouLikeAdapter();
						StidInfo info = (StidInfo) JsonParser.getGuessYouLike(
								json).get(JsonParser.STID_INFO);
						mGuessYouLikeAdapter.bataData(info.getData());
						mListView.setAdapter(mGuessYouLikeAdapter);
					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {

					}
				});
		request.setShouldCache(false);
		mQueue.add(request);

	}

	// ---------------------------------------------------------------------------------------------------
	class CityAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return 50;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(parent.getContext()).inflate(
						R.layout.sub_city_grid_view_item, parent, false);
			}

			return convertView;
		}

	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if (isChecked) {
			mPopupWindow.showAsDropDown(getView().findViewById(
					R.id.top_action_bar));
		}
	}

	@Override
	public void onDismiss() {
		mCurrentCity.setChecked(false);
	}

	// ----------------------------------------------------------------------------------------------------
	class GoodsTypeAdapter extends BaseAdapter {

		private ArrayList<Morepage> data = new ArrayList<Morepage>();

		public void bindData(ArrayList<Morepage> data) {

			if (data != null) {
				this.data = data;
			}

		}

		@Override
		public int getCount() {
			return data.size();
		}

		@Override
		public Object getItem(int position) {
			return data.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(parent.getContext()).inflate(
						R.layout.grid_view_goods_type_item, parent, false);
			}

			final TextView tv = (TextView) convertView
					.findViewById(R.id.goods_type_name);
			final ImageView img = (ImageView) convertView
					.findViewById(R.id.goods_type_image);
			tv.setText(data.get(position).getName());
			ImageListener listener = ImageLoader.getImageListener(img,
					R.drawable.ic_launcher, R.drawable.ic_launcher);
			mImageLoader.get(data.get(position).getIconUrl(), listener);
			return convertView;
		}

	}

	// -----------------------------------------------------------------------------------------------------

	class SnapUpAdapter extends BaseAdapter {

		private ArrayList<Deal> data = new ArrayList<Deal>();

		public void bindData(ArrayList<Deal> data) {

			if (data != null) {
				this.data = data;
			}
		}

		@Override
		public int getCount() {
			return data.size();
		}

		@Override
		public Object getItem(int position) {
			return data.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			if (convertView == null) {

				convertView = LayoutInflater.from(parent.getContext()).inflate(
						R.layout.snapup_item, parent, false);

			}

			TextView tv = (TextView) convertView.findViewById(R.id.deal_name);
			ImageView img = (ImageView) convertView.findViewById(R.id.icon);
			tv.setText(data.get(position).getCateDesc());

			ImageListener listener = ImageLoader.getImageListener(img,
					R.drawable.ic_launcher, R.drawable.ic_launcher);
			mImageLoader.get(data.get(position).getMdcLogoUrl(), listener);
			return convertView;
		}

	}

	// ------------------------------------------------------------------------------------------------------
	class FavorableAdapter extends BaseAdapter {

		private ArrayList<Favorable> data = new ArrayList<Favorable>();

		public void bindData(ArrayList<Favorable> data) {

			if (data != null) {
				this.data = data;
			}
		}

		@Override
		public int getCount() {
			return data.size();
		}

		@Override
		public Object getItem(int position) {
			return data.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			if (convertView == null) {

				convertView = LayoutInflater.from(parent.getContext()).inflate(
						R.layout.favorable_item, parent, false);

			}

			ImageView img = (ImageView) convertView.findViewById(R.id.icon);
			ImageListener listener = ImageLoader.getImageListener(img,
					R.drawable.ic_launcher, R.drawable.ic_launcher);

			String imgUrl = UrlFormat.formatGYLImgUrl(data.get(position)
					.getImageurl());
			mImageLoader.get(imgUrl, listener);
			return convertView;
		}

	}

	// -------------------------------------------------------------------------------------------

	class GuessYouLikeAdapter extends BaseAdapter {

		class ViewHolder {

			private ImageView img;
			private TextView titleTv;
			private TextView distanceTv;
			private TextView descriptionTv;
			private TextView priceTv;
			private TextView selledTv;

		}

		private ArrayList<StidData> data = new ArrayList<StidData>();

		public GuessYouLikeAdapter() {

		}

		public void bataData(ArrayList<StidData> data) {
			if (data != null) {
				this.data = data;
			}
		}

		@Override
		public int getCount() {
			return data.size();
		}

		@Override
		public Object getItem(int position) {
			return data.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			ViewHolder viewHolder = null;

			if (convertView == null) {
				convertView = LayoutInflater.from(parent.getContext()).inflate(
						R.layout.guess_you_like_item, parent, false);

				viewHolder = new ViewHolder();
				viewHolder.img = (ImageView) convertView.findViewById(R.id.img);
				viewHolder.titleTv = (TextView) convertView
						.findViewById(R.id.title);
				viewHolder.distanceTv = (TextView) convertView
						.findViewById(R.id.distance);
				viewHolder.descriptionTv = (TextView) convertView
						.findViewById(R.id.description);
				viewHolder.priceTv = (TextView) convertView
						.findViewById(R.id.price);
				viewHolder.selledTv = (TextView) convertView
						.findViewById(R.id.selled);

				convertView.setTag(viewHolder);
			}

			StidData stidData = data.get(position);
			viewHolder = (ViewHolder) convertView.getTag();
			viewHolder.titleTv.setText(stidData.getBrandname());

			viewHolder.priceTv.setText(Html.fromHtml(String.format(
					getString(R.string.price), stidData.getPrice(), 12)));
			viewHolder.distanceTv.setText(String.format(
					getString(R.string.disance), stidData.getDt()));
			viewHolder.selledTv.setText(String.format(
					getString(R.string.selled), stidData.getSolds()));
			viewHolder.descriptionTv.setText(stidData.getTitle());
			ImageListener listener = ImageLoader.getImageListener(
					viewHolder.img, R.drawable.ic_launcher,
					R.drawable.ic_launcher);
			mImageLoader.get(UrlFormat.formatGYLImgUrl(stidData.getImgurl()),
					listener);

			return convertView;
		}
	}

}

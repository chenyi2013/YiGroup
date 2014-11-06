package com.kevin.yigroup.fragment;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.kevin.yigroup.R;
import com.kevin.yigroup.YiGroupApplication;
import com.kevin.yigroup.cache.BitmapCache;
import com.kevin.yigroup.config.URLS;
import com.kevin.yigroup.entity.Shops;
import com.kevin.yigroup.entity.ShopsInfo;
import com.kevin.yigroup.utils.JsonParser;
import com.kevin.yigroup.utils.UrlFormat;
import com.kevin.yigroup.view.StartView;

public class AllShopsFragment extends Fragment {

	private ListView mAllShopsListView;
	private ArrayList<Shops> mShops;
	private ShopsInfo mShopsInfo;

	private YiGroupApplication mApplication;
	private RequestQueue mRequestQueue;
	private ImageLoader mImageLoader;
	private BitmapCache mBitmapCache;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mApplication = (YiGroupApplication) getActivity().getApplication();
		mBitmapCache = mApplication.getBitmapCache();
		mRequestQueue = mApplication.getRequestQueue();
		mImageLoader = new ImageLoader(mRequestQueue, mBitmapCache);
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_all_shops, container, false);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initView();
		loadData();
	}

	private void initView() {
		mAllShopsListView = (ListView) getActivity().findViewById(
				R.id.all_shops_list_view);
		mAllShopsListView.setDivider(null);
	}

	private void loadData() {
		mRequestQueue.add(new StringRequest(URLS.ALL_SHOPS_URL,
				new Listener<String>() {

					@Override
					public void onResponse(String json) {
						mShopsInfo = JsonParser.getParsedData(json,
								ShopsInfo.class);
						mShops = mShopsInfo.getData();
						mAllShopsListView.setAdapter(new AllShopsAdapter());
					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {

					}
				}));
	}

	class AllShopsAdapter extends BaseAdapter {

		private int flag;

		class ViewHolder {

			ImageView icon;
			TextView titleTv;
			ImageView groupIcon;
			TextView estimateTv;
			TextView priceTv;
			TextView addressTv;
			TextView distanceTv;
			StartView startView;

		}

		@Override
		public int getCount() {
			return mShops.size();
		}

		@Override
		public Object getItem(int position) {
			return mShops.get(position);
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
						R.layout.all_shops_list_view_item, parent, false);

				viewHolder = new ViewHolder();
				viewHolder.icon = (ImageView) convertView
						.findViewById(R.id.icon);
				viewHolder.titleTv = (TextView) convertView
						.findViewById(R.id.title);
				viewHolder.groupIcon = (ImageView) convertView
						.findViewById(R.id.group_icon);
				viewHolder.addressTv = (TextView) convertView
						.findViewById(R.id.address);
				viewHolder.distanceTv = (TextView) convertView
						.findViewById(R.id.distance);
				viewHolder.priceTv = (TextView) convertView
						.findViewById(R.id.price);
				viewHolder.estimateTv = (TextView) convertView
						.findViewById(R.id.estimate_count);
				viewHolder.startView = (StartView) convertView
						.findViewById(R.id.star_icon);

				convertView.setTag(viewHolder);
			}

			Shops shops = mShops.get(position);
			viewHolder = (ViewHolder) convertView.getTag();
			viewHolder.titleTv.setText(shops.getName());
			viewHolder.estimateTv.setText(String.format(
					getString(R.string.mark_num), shops.getMarkNumbers()));

			if (shops.getAvgPrice() > 0.00001) {
				viewHolder.priceTv.setText(String.format(
						getString(R.string.avg_price), shops.getAvgPrice()));
			} else {
				viewHolder.priceTv.setText("");
			}

			viewHolder.addressTv.setText(shops.getCateName() + " "
					+ shops.getAreaName());
			flag = shops.isHasGroup() ? View.VISIBLE : View.GONE;
			viewHolder.groupIcon.setVisibility(flag);
			ImageListener imageListener = ImageLoader.getImageListener(
					viewHolder.icon, R.drawable.ic_launcher,
					R.drawable.ic_launcher);
			mImageLoader.get(UrlFormat.formatGYLImgUrl(shops.getFrontImg()),
					imageListener);
			viewHolder.startView.setAvgScore(shops.getAvgScore());
			return convertView;
		}

	}

}

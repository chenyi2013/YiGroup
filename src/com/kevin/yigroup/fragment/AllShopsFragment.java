package com.kevin.yigroup.fragment;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response.Listener;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.kevin.yigroup.R;
import com.kevin.yigroup.YiGroupApplication;
import com.kevin.yigroup.cache.BitmapCache;
import com.kevin.yigroup.config.URLS;
import com.kevin.yigroup.entity.Shops;
import com.kevin.yigroup.entity.ShopsInfo;
import com.kevin.yigroup.utils.JsonParser;

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
	}

	private void loadData() {
		mRequestQueue.add(new StringRequest(URLS.ALL_SHOPS_URL,
				new Listener<String>() {

					@Override
					public void onResponse(String json) {
						mShopsInfo = JsonParser.getParsedData(json,
								ShopsInfo.class);
						mShops = mShopsInfo.getData();
					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {

					}
				}));
	}

	class AllShopsAdapter extends BaseAdapter {

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
			return null;
		}

	}

}

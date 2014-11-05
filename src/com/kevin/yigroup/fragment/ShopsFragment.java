package com.kevin.yigroup.fragment;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.kevin.yigroup.R;
import com.kevin.yigroup.YiGroupApplication;
import com.kevin.yigroup.config.URLS;
import com.kevin.yigroup.entity.AreaInfo;
import com.kevin.yigroup.entity.GoodsType;
import com.kevin.yigroup.entity.Subareasinfo;
import com.kevin.yigroup.utils.JsonParser;

public class ShopsFragment extends Fragment implements OnClickListener,
		OnItemClickListener, ViewPager.OnPageChangeListener,
		OnCheckedChangeListener {

	private RadioGroup mShopsMenu;
	private RadioGroup mTopTab;
	private ListView mLeftListView;
	private ListView mRightListView;
	private ViewPager mShopsViewPager;
	private View mListMenuBg;
	private View mListMenu;

	private GoodsTypeAdapter mAdapter;
	private GoodsTypeAdapter mSubAdapter;
	private AreaInfoAdapter mAreaInfoAdapter;
	private AreaInfoAdapter mSubAreaInfoAdapter;
	private ShopsPagerAdapter mShopsPagerAdapter;

	private int tag = -1;

	private ArrayList<GoodsType> mGoodsTypes;
	private ArrayList<GoodsType> mSubGoodsTypes;
	private ArrayList<Subareasinfo> mAreas;
	private ArrayList<Subareasinfo> mSubAreas;
	private ArrayList<Fragment> mFragments;
	private AreaInfo mAreaInfo;

	private YiGroupApplication mApplication;
	private RequestQueue mRequestQueue;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mApplication = (YiGroupApplication) getActivity().getApplication();
		mRequestQueue = mApplication.getRequestQueue();
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_shops, container, false);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		initView();
		loadData();

	}

	public void initView() {
		System.out.println("start");

		mListMenuBg = getView().findViewById(R.id.menu_bg);
		mListMenuBg.setOnClickListener(this);
		mListMenu = getView().findViewById(R.id.list_menu);

		mFragments = new ArrayList<Fragment>();
		mFragments.add(new AllShopsFragment());
		mFragments.add(new VIPShopsFragment());

		mShopsPagerAdapter = new ShopsPagerAdapter(getChildFragmentManager());
		mShopsViewPager = (ViewPager) getView().findViewById(
				R.id.framgent_shops_view_pager);
		mShopsViewPager.setAdapter(mShopsPagerAdapter);
		mShopsViewPager.setOnPageChangeListener(this);

		mAdapter = new GoodsTypeAdapter();
		mSubAdapter = new GoodsTypeAdapter();
		mAreaInfoAdapter = new AreaInfoAdapter();
		mSubAreaInfoAdapter = new AreaInfoAdapter();

		mLeftListView = (ListView) getView()
				.findViewById(R.id.left_choice_zone);
		mLeftListView.setAdapter(mAdapter);
		mLeftListView.setOnItemClickListener(this);

		mRightListView = (ListView) getView().findViewById(
				R.id.right_choice_zone);
		mRightListView.setAdapter(mSubAdapter);

		mTopTab = (RadioGroup) getView().findViewById(R.id.top_tab);
		mTopTab.setOnCheckedChangeListener(this);

		mShopsMenu = (RadioGroup) getView().findViewById(R.id.shops_menu);

		RadioButton allCategory = (RadioButton) mShopsMenu
				.findViewById(R.id.all_catalogue);
		allCategory.setOnClickListener(this);

		RadioButton choiceZone = (RadioButton) mShopsMenu
				.findViewById(R.id.choice_zone);
		choiceZone.setOnClickListener(this);

		RadioButton orderType = (RadioButton) mShopsMenu
				.findViewById(R.id.order_type);
		orderType.setOnClickListener(this);

	}

	private void loadData() {
		mRequestQueue.add(new StringRequest(URLS.GOODS_TYPE_LIST_URL,
				new Listener<String>() {

					@Override
					public void onResponse(String json) {
						mGoodsTypes = JsonParser.getGoodsType(json);
					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {

					}
				}));

		mRequestQueue.add(new StringRequest(URLS.AREA_URL,
				new Listener<String>() {

					@Override
					public void onResponse(String json) {
						mAreaInfo = JsonParser.getAreaInfo(json);
						mAreas = mAreaInfo.getAreasinfo();
					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {

					}
				}));

	}

	private void switchVisiblity() {

		if (mListMenu.getVisibility() == View.VISIBLE) {
			mListMenu.setVisibility(View.GONE);
		} else {
			mListMenu.setVisibility(View.VISIBLE);
		}

		if (mListMenuBg.getVisibility() == View.VISIBLE) {
			mListMenuBg.setVisibility(View.GONE);
		} else {
			mListMenuBg.setVisibility(View.VISIBLE);
		}

	}

	private ArrayList<Subareasinfo> formatSubareasinfos(ArrayList<Integer> data) {

		ArrayList<Subareasinfo> allAreasInfo = mAreaInfo.getSubareasinfo();
		ArrayList<Subareasinfo> areasinfos = new ArrayList<Subareasinfo>();
		Subareasinfo areaInfo = null;

		for (int i = 0; i < data.size(); i++) {

			for (int j = 0; j < allAreasInfo.size(); j++) {
				areaInfo = allAreasInfo.get(j);
				if (data.get(i) == areaInfo.getId()) {
					areasinfos.add(areaInfo);
					break;
				}

			}

		}
		return areasinfos;

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.all_catalogue:

			if (tag != R.id.all_catalogue) {
				mListMenuBg.setVisibility(View.VISIBLE);
				mListMenu.setVisibility(View.VISIBLE);
				if (mGoodsTypes != null) {
					mAdapter.bindData(mGoodsTypes);
					mLeftListView.setAdapter(mAdapter);
					mRightListView.setVisibility(View.VISIBLE);
					mRightListView.setAdapter(null);
					mAdapter.notifyDataSetChanged();
				}

			} else {
				switchVisiblity();
			}

			tag = R.id.all_catalogue;

			break;
		case R.id.choice_zone:

			if (tag != R.id.choice_zone) {
				mListMenuBg.setVisibility(View.VISIBLE);
				mListMenu.setVisibility(View.VISIBLE);

				if (mAreas != null) {
					mAreaInfoAdapter.bindData(mAreas);
					mLeftListView.setAdapter(mAreaInfoAdapter);
					mRightListView.setVisibility(View.VISIBLE);
					mRightListView.setAdapter(null);
					mAreaInfoAdapter.notifyDataSetChanged();
				}

			} else {
				switchVisiblity();
			}

			tag = R.id.choice_zone;

			break;
		case R.id.order_type:
			if (tag != R.id.order_type) {
				mListMenuBg.setVisibility(View.VISIBLE);
				mListMenu.setVisibility(View.VISIBLE);
				mRightListView.setVisibility(View.GONE);

				mRightListView.setAdapter(null);
				mLeftListView.setAdapter(null);

			} else {
				switchVisiblity();
			}

			tag = R.id.order_type;

			break;

		case R.id.menu_bg:
			mListMenuBg.setVisibility(View.GONE);
			mListMenu.setVisibility(View.GONE);
			tag = R.id.menu_bg;
			break;
		}

	}

	// --------------------------------------------------------------------------------------
	class GoodsTypeAdapter extends BaseAdapter {

		private ArrayList<GoodsType> data = new ArrayList<GoodsType>();

		public void bindData(ArrayList<GoodsType> data) {

			if (data != null) {
				this.data = data;
			} else {
				this.data = new ArrayList<GoodsType>();
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
						R.layout.shops_fragment_left_list_item, parent, false);
			}

			TextView tv = (TextView) convertView;
			if (data.get(position).getList() == null) {
				tv.setCompoundDrawables(null, null, null, null);
			}
			tv.setText(data.get(position).getName());

			return convertView;
		}

	}

	// -------------------------------------------------------------------------------------------
	class AreaInfoAdapter extends BaseAdapter {

		private ArrayList<Subareasinfo> data = new ArrayList<Subareasinfo>();

		public void bindData(ArrayList<Subareasinfo> data) {

			if (data != null) {
				this.data = data;
			} else {
				this.data = new ArrayList<Subareasinfo>();
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
						R.layout.shops_fragment_left_list_item, parent, false);
			}

			Subareasinfo info = data.get(position);
			TextView tv = (TextView) convertView;
			tv.setText(info.getName());

			if (info.getSubareas() == null || info.getSubareas().size() == 0) {
				tv.setCompoundDrawables(null, null, null, null);
			}

			return convertView;
		}

	}

	// ---------------------------------------------------------------------------------------
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		switch (tag) {
		case R.id.all_catalogue:

			GoodsType goodsType = mGoodsTypes.get(position);
			if (goodsType != null) {

				mSubGoodsTypes = goodsType.getList();
				mSubAdapter.bindData(mSubGoodsTypes);
				mRightListView.setAdapter(mSubAdapter);
				mSubAdapter.notifyDataSetChanged();
			} else {

				mSubAdapter.bindData(null);
				mSubAdapter.notifyDataSetChanged();
			}

			break;
		case R.id.choice_zone:

			Subareasinfo info = mAreas.get(position);
			mSubAreas = formatSubareasinfos(info.getSubareas());
			mSubAreaInfoAdapter.bindData(mSubAreas);
			mRightListView.setAdapter(mSubAreaInfoAdapter);
			mSubAreaInfoAdapter.notifyDataSetChanged();

			break;

		default:
			break;
		}

	}

	// --------------------------------------------------------------------------------
	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	@Override
	public void onPageSelected(int position) {

		if (position == 0) {
			mTopTab.check(R.id.all_shops);
		} else if (position == 1) {
			mTopTab.check(R.id.vip_shops);
		}

	}

	// --------------------------------------------------------------------------------

	class ShopsPagerAdapter extends FragmentPagerAdapter {

		public ShopsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return mFragments.get(position);
		}

		@Override
		public int getCount() {
			return mFragments.size();
		}

	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {

		switch (checkedId) {
		case R.id.all_shops:

			mShopsViewPager.setCurrentItem(0);

			break;
		case R.id.vip_shops:
			mShopsViewPager.setCurrentItem(1);
			break;

		}

	}
}

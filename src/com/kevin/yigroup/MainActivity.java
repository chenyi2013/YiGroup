package com.kevin.yigroup;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.kevin.yigroup.fragment.GroupPurchaseFragment;
import com.kevin.yigroup.fragment.MeFragment;
import com.kevin.yigroup.fragment.MoreFragment;
import com.kevin.yigroup.fragment.ShopsFragment;

public class MainActivity extends FragmentActivity implements
		OnCheckedChangeListener {

	private RadioGroup mBottomTab;
	private GroupPurchaseFragment mGroupPurchaseFragment;
	private ShopsFragment mShopsFragment;
	private MeFragment mMeFragment;
	private MoreFragment mMoreFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();

	}

	private void initView() {

		mBottomTab = (RadioGroup) findViewById(R.id.bottom_tab);
		mBottomTab.setOnCheckedChangeListener(this);

		mGroupPurchaseFragment = new GroupPurchaseFragment();
		mShopsFragment = new ShopsFragment();
		mMeFragment = new MeFragment();
		mMoreFragment = new MoreFragment();

		getSupportFragmentManager().beginTransaction()
				.add(R.id.main_layout, mGroupPurchaseFragment).commit();
		mBottomTab.check(R.id.group_purcashe);
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.group_purcashe:
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.main_layout, mGroupPurchaseFragment).commit();
			break;
		case R.id.shops:
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.main_layout, mShopsFragment).commit();

			break;
		case R.id.me:
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.main_layout, mMeFragment).commit();

			break;
		case R.id.more:
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.main_layout, mMoreFragment).commit();

			break;
		}

	}

}

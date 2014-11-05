package com.kevin.yigroup.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

public class DisplayUtils {

	Context mContext;

	public DisplayUtils(Context context) {
		mContext = context;
	}

	/**
	 * �õ��豸����Ļ�߶�
	 * 
	 * @return
	 */
	public int getDisplayHeight() {

		DisplayMetrics metrics = new DisplayMetrics();

		WindowManager windowManager = (WindowManager) mContext
				.getSystemService(Context.WINDOW_SERVICE);

		windowManager.getDefaultDisplay().getMetrics(metrics);

		return metrics.heightPixels;
	}

	/**
	 * �õ��豸����Ļ���
	 * 
	 * @return
	 */
	public int getDisplayWidth() {

		DisplayMetrics metrics = new DisplayMetrics();

		WindowManager windowManager = (WindowManager) mContext
				.getSystemService(Context.WINDOW_SERVICE);

		windowManager.getDefaultDisplay().getMetrics(metrics);

		return metrics.widthPixels;

	}

	/**
	 * ����View�ĸ߶�
	 * 
	 * @param view
	 * @return
	 */
	public int measureViewHeight(View view) {

		int w = View.MeasureSpec.makeMeasureSpec(0,
				View.MeasureSpec.UNSPECIFIED);
		int h = View.MeasureSpec.makeMeasureSpec(0,
				View.MeasureSpec.UNSPECIFIED);
		view.measure(w, h);
		return view.getMeasuredHeight();

	}

}

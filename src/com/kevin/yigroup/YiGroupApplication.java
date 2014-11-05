package com.kevin.yigroup;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.kevin.yigroup.cache.BitmapCache;

public class YiGroupApplication extends Application {

	private BitmapCache bitmapCache;
	private RequestQueue mRequestQueue;

	public synchronized BitmapCache getBitmapCache() {

		if (bitmapCache == null) {
			bitmapCache = new BitmapCache();
		}
		return bitmapCache;
	}

	public synchronized RequestQueue getRequestQueue() {
		if (mRequestQueue == null) {
			mRequestQueue = Volley.newRequestQueue(getApplicationContext());
		}

		return mRequestQueue;
	}

	public int getAppVersion(Context context) {
		try {
			PackageInfo info = context.getPackageManager().getPackageInfo(
					context.getPackageName(), 0);
			return info.versionCode;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return 1;
	}
}

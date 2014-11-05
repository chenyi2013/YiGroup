package com.kevin.yigroup.cache;

import android.graphics.Bitmap;

import com.android.volley.toolbox.ImageLoader.ImageCache;

public class BitmapCache implements ImageCache {

	CacheUtils<String, Bitmap> cacheUtils;

	public BitmapCache() {
		cacheUtils = new CacheUtils<String, Bitmap>(
				CacheUtils.getSuggestCacheSize());
	}

	@Override
	public void putBitmap(String key, Bitmap bitmap) {
		cacheUtils.getLruCache().put(key, bitmap);
	}

	@Override
	public Bitmap getBitmap(String key) {
		return cacheUtils.getLruCache().get(key);
	}

}

package com.kevin.yigroup.cache;

import java.io.Closeable;
import java.io.IOException;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.util.Log;

public class CacheUtils<K, V> {
	private static final String TAG = "CacheUtils";

	/**
	 * �������󣬻�������б�Ҫ��Ƴɵ���
	 */
	private LruCache<K, V> mCache;

	/**
	 * ����Ĵ�С
	 */
	private int mCacheSize;

	/**
	 * ָ������Ĵ�С�����ֽ�Ϊ��λ
	 * 
	 * @param size
	 */
	public CacheUtils(int size) {
		mCacheSize = size;
	}

	/**
	 * �õ�һ��ָ�����͵�LRU���档LruCache�����̰߳�ȫģ��ʵ�ֵģ�����û�б�Ҫ�ټ�����
	 * 
	 * @return
	 */
	public LruCache<K, V> getLruCache() {
		if (mCache == null) {
			mCache = new LruCache<K, V>(mCacheSize) {
				@Override
				protected int sizeOf(K key, V value) {
					int entitySize = 1;
					if (value instanceof CharSequence) {
						entitySize = value.toString().getBytes().length;
					} else if (value instanceof Bitmap) {
						entitySize = ((Bitmap) value).getRowBytes()
								* ((Bitmap) value).getHeight();
					} else {
						Log.d(TAG, "�������" + value.getClass()
								+ "�Ĵ�С������дsizeOf����");
					}
					return entitySize;
				}

				@Override
				protected void entryRemoved(boolean evicted, K key, V oldValue,
						V newValue) {
					super.entryRemoved(evicted, key, oldValue, newValue);
					if (oldValue instanceof Closeable) {
						try {
							((Closeable) oldValue).close();
							oldValue = null;
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if (oldValue instanceof Bitmap) {
						((Bitmap) oldValue).recycle();
						oldValue = null;
					} else {
						Log.d(TAG, "��������" + oldValue.getClass()
								+ "������Դ������дentryRemoved����");
					}
				}

			};
		}
		return mCache;
	}

	/**
	 * �õ�����Ļ����С
	 * 
	 * @param portion
	 *            �����С���豸�����ڴ�� portion ��֮һ
	 * @return
	 */
	public static int getSuggestCacheSize(int portion) {
		long MAX_SIZE = Runtime.getRuntime().maxMemory();
		return (int) (MAX_SIZE / portion);
	}

	/**
	 * ����Ϊ�豸����ڴ��8��֮һ
	 * 
	 * @return
	 */
	public static int getSuggestCacheSize() {
		return getSuggestCacheSize(8);
	}

	/**
	 * �жϻ��������Ƿ����õķ�ֵ
	 */
	private final float GOOD_THRESHOLD = 0.8f;

	/**
	 * �жϻ��������Ƿ�����
	 * 
	 * ��������ʲ��ߣ����Կ������󻺴��С
	 * 
	 * @return
	 */
	public boolean isGoodCache() {
		return mCache != null ? (mCache.hitCount() / mCache.putCount()) > GOOD_THRESHOLD
				: false;
	}
}

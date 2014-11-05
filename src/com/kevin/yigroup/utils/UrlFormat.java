package com.kevin.yigroup.utils;

import android.os.Build;

public class UrlFormat {

	public static String formatGYLImgUrl(String url) {

		String formatUrl = url.replace("meituan.net/w.h", "meituan.net/0.160");

		if (Build.VERSION.SDK_INT >= 14) {
			formatUrl = formatUrl + ".webp";
		}

		return formatUrl;
	}
}

package com.kevin.yigroup.utils;

import java.io.File;
import java.io.IOException;

import android.content.Context;
import android.os.Environment;

public class FileHelper {

	public static boolean isMounted() {

		return Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState());

	}

	public static String getDirPath(Context context) {

		if (isMounted()|| !Environment.isExternalStorageRemovable()) {

			return context.getExternalCacheDir().getAbsolutePath();

		} else {
			return context.getCacheDir().getAbsolutePath();
		}

	}

	public static File getDir(Context context, String dirName) {

		String dirPath = getDirPath(context) + File.separator + dirName;
		File dir = new File(dirPath);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		return dir;

	}

	public static File getFile(Context context, String fileName) {

		String dirPath = getDirPath(context) + File.separator + fileName;
		File file = new File(dirPath);
		if (!file.exists()) {
			try {
				file.createNewFile();
				return file;
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return null;

	}
}

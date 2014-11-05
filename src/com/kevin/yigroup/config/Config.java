package com.kevin.yigroup.config;

public class Config {

	/**
	 * 硬盘缓存目录
	 */
	public static final String DISK_CACHE_DIR = "yigroup";

	/**
	 * 硬盘缓存大小
	 */
	public static final long DISK_CACHE_SIZE = 1024 * 1024 * 20;

	/**
	 * 每个entry对应的缓存文件的格式，一般情况下，该值为1
	 */
	public static final int DISK_CACHE_VALUE_COUNT = 1;

}

package com.kevin.yigroup.utils;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.kevin.yigroup.entity.AreaInfo;
import com.kevin.yigroup.entity.GoodsType;
import com.kevin.yigroup.entity.MeiTuanFood;
import com.kevin.yigroup.entity.MovieFirst;
import com.kevin.yigroup.entity.StidInfo;
import com.kevin.yigroup.entity.SurveyContent;

public class JsonParser {

	public static final String STID_INFO = "stidInfo";
	public static final String SURVEY_CONTENT = "surveyContent";

	private static final String STID_INFO_ROOT = "http://api.mobile.meituan.com/group/"
			+ "v1/recommend/homepage/city/1?fields=id,slug,cate,subcate,dtype,ctype,mlls"
			+ ",solds,status,range,start,end,imgurl,squareimgurl,title,price,value,mname"
			+ ",brandname,rating,rate_count,satisfaction,mealcount,nobooking,attrJson,ho"
			+ "telExt,campaigns,terms,recreason,showtype,deposit,securityinfo,optionalatt"
			+ "rs,bookinginfo,pricecalendar,isappointonline&client=android&utm_source=qih"
			+ "u360&utm_medium=android&utm_term=197&version_name=4.9.7&utm_content=8611380"
			+ "20353286&utm_campaign=AgroupBgroupC0E0&ci=1&uuid=007EDB672C56E223985B5DE73F"
			+ "9B308D0CC64AE05F54B963366B06C3912B9A9A&msid=8611380203532861325942060833";

	private static final String SURVEY_CONTENT_ROOT = "http://api.mobile.meituan.com/group/"
			+ "v1/recommend/007EDB672C56E223985B5DE73F9B308D0CC64AE05F54B963366B06C3912B9A9A/"
			+ "survey?utm_source=qihu360&utm_medium=android&utm_term=197&version_name=4.9.7&"
			+ "utm_content=861138020353286&utm_campaign=AgroupBgroupC0E0&ci=1&uuid=007EDB672C"
			+ "56E223985B5DE73F9B308D0CC64AE05F54B963366B06C3912B9A9A&msid=861138020353286132"
			+ "5942060833";

	private static final String GOODS_DETAILS_MOVIES_ARG1 = "http://api.mobile.meituan.com/dianying/"
			+ "v4/movies.json?tp=hot&ct=±±¾©&order=show_desc&dt=2015-01-04&movieBundleVersion=80&"
			+ "utm_source=meizu&utm_medium=android&utm_term=212&version_name=5.1.2&utm_content="
			+ "861138020353286&utm_campaign=AgroupBgroupC0E0Fa510tab__b__leftflow___a500poi2__a__1a"
			+ "___a500poi3__a__leftflow___ab_gxhceshi__nostrategy__leftflow___ab_gxh_82__nostrategy__"
			+ "leftflowGhomepage_category1_99&ci=1&uuid=007EDB672C56E223985B5DE73F9B308D0CC64AE05F54B96"
			+ "3366B06C3912B9A9A&msid=8611380203532861420356394308";

	private static final String GOODS_DETAILS_MOVIES_ARG2 = "http://api.mobile.meituan.com/group/v1/"
			+ "user/-1/poi/collections/get?token=&offset=0&limit=20&cate=99&cityId=1&utm_source=meizu"
			+ "&utm_medium=android&utm_term=212&version_name=5.1.2&utm_content=861138020353286&utm_"
			+ "campaign=AgroupBgroupC0E0Fa510tab__b__leftflow___a500poi2__a__1a___a500poi3__a__leftf"
			+ "low___ab_gxhceshi__nostrategy__leftflow___ab_gxh_82__nostrategy__leftflowGhomepage_ca"
			+ "tegory1_99&ci=1&uuid=007EDB672C56E223985B5DE73F9B308D0CC64AE05F54B963366B06C3912B9A9A&"
			+ "msid=8611380203532861420356394308";

	public static <T> T getParsedData(String json, Class<T> cls) {

		json = json.replace("rate-count", "rate_count");

		return JSON.parseObject(json, cls);

	}

	public static MeiTuanFood getMeiTuanFood(String json) {

		HashMap<String, MeiTuanFood> map = JSON.parseObject(json,
				new TypeReference<HashMap<String, MeiTuanFood>>() {
				}, Feature.IgnoreNotMatch);

		return map.get("data");

	}

	public static ArrayList<GoodsType> getGoodsType(String json) {

		HashMap<String, ArrayList<GoodsType>> map = JSON.parseObject(json,
				new TypeReference<HashMap<String, ArrayList<GoodsType>>>() {
				}, Feature.IgnoreNotMatch);

		return map.get("data");

	}

	public static AreaInfo getAreaInfo(String json) {
		HashMap<String, AreaInfo> map = JSON.parseObject(json,
				new TypeReference<HashMap<String, AreaInfo>>() {
				}, Feature.IgnoreNotMatch);

		return map.get("data");
	}

	public static HashMap<String, Object> getGuessYouLike(String json) {

		try {
			json = json.replace("rate-count", "rate_count");
			JSONObject jsonObject = new JSONObject(json).getJSONObject("data");

			StidInfo stidInfo = JSON.parseObject(jsonObject.get(STID_INFO_ROOT)
					.toString(), StidInfo.class);

			SurveyContent surveyContent = JSON.parseObject(jsonObject
					.getJSONObject(SURVEY_CONTENT_ROOT).getJSONObject("data")
					.getJSONObject(SURVEY_CONTENT).toString(),
					SurveyContent.class);

			HashMap<String, Object> maps = new HashMap<String, Object>();
			maps.put(STID_INFO, stidInfo);
			maps.put(SURVEY_CONTENT, surveyContent);

			return maps;

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return null;
	}

	public static ArrayList<MovieFirst> getMoviewFirsts(String json) {
		JSONObject jsonObject = null;
		ArrayList<MovieFirst> list = null;
		try {
			jsonObject = new JSONObject(json);
			String js = jsonObject.getJSONObject("data")
					.getJSONObject(GOODS_DETAILS_MOVIES_ARG1)
					.getJSONArray("first").toString();
			list = JSON.parseObject(js,
					new TypeReference<ArrayList<MovieFirst>>() {
					}, Feature.IgnoreNotMatch);

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return list;
	}
}

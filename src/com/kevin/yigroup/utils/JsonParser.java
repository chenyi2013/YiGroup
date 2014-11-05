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

}

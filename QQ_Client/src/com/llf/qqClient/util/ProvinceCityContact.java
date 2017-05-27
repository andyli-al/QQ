package com.llf.qqClient.util;

/**
 * 
 * @author llf
 * 省市关联处理类
 */
public class ProvinceCityContact {

	/**
	 * 
	 * @param province
	 * @return cities
	 */
	public static String[] getCitiesByProvince(String province)
	{
		//模拟设置各个省份只提供5个可选下辖市区
		String cities[]=new String[10];
		
		switch(province)
		{
		   case "北京":
			   cities[0]="东城";
			   cities[1]="西城";
			   cities[2]="朝阳";
			   cities[3]="海淀";
			   cities[4]="昌平";
			   break;
		   case "上海":
			   cities[0]="黄浦";
			   cities[1]="虹口";
			   cities[2]="宝山";
			   cities[3]="嘉定";
			   cities[4]="浦东新区";
			   break;
		   case "天津":
			   cities[0]="和平";
			   cities[1]="河东";
			   cities[2]="河西";
			   cities[3]="南开";
			   cities[4]="津南";
			   break;
		   case "重庆":
			   cities[0]="渝中";
			   cities[1]="江北";
			   cities[2]="南岸";
			   cities[3]="沙坪坝";
			   cities[4]="万州";
			   break;
		   case "江苏":
			   cities[0]="南京";
			   cities[1]="无锡";
			   cities[2]="徐州";
			   cities[3]="常州";
			   cities[4]="苏州";
			   break;
		   case "浙江":
			   cities[0]="杭州";
			   cities[1]="宁波";
			   cities[2]="温州";
			   cities[3]="嘉兴";
			   cities[4]="绍兴";
			   break;
		   case "广东":
			   cities[0]="广州";
			   cities[1]="深圳";
			   cities[2]="东莞";
			   cities[3]="佛山";
			   cities[4]="珠海";
			   break;
		   case "福建":
			   cities[0]="福州";
			   cities[1]="厦门";
			   cities[2]="泉州";
			   cities[3]="莆田";
			   cities[4]="龙岩";
			   break;
		   case "山东":
			   cities[0]="济南";
			   cities[1]="青岛";
			   cities[2]="烟台";
			   cities[3]="日照";
			   cities[4]="莱芜";
			   break;
		   case "辽宁":
			   cities[0]="沈阳";
			   cities[1]="大连";
			   cities[2]="抚顺";
			   cities[3]="丹东";
			   cities[4]="锦州";
			   break;
		   case "内蒙古":
			   cities[0]="呼和浩特";
			   cities[1]="包头";
			   cities[2]="呼伦贝尔";
			   cities[3]="赤峰";
			   cities[4]="鄂尔多斯";
			   break;
		}
		
		
		return cities;
	}
}

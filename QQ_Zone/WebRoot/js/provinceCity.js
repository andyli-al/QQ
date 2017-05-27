   function change_province()
	{
	   $("#stayCity_city").empty();
	   if($("#stayCity_province").val()=='北京')
	   {
	      var str="<option value='东城'>东城</option><option value='西城'>西城</option><option value='朝阳'>朝阳</option><option value='海淀'>海淀</option><option value='昌平'>昌平</option>";
	   }
	   else if($("#stayCity_province").val()=='上海')
	   {
	      var str="<option value='黄埔'>黄埔</option><option value='虹口'>虹口</option><option value='宝山'>宝山</option><option value='嘉定'>嘉定</option><option value='浦东新区'>浦东新区</option>";
	   }
	   else if($("#stayCity_province").val()=='天津')
	   {
	      var str="<option value='和平'>和平</option><option value='河东'>河东</option><option value='河西'>河西</option><option value='南开'>南开</option><option value='津南'>津南</option>";
	   } 
	   else if($("#stayCity_province").val()=='重庆')
	   {
	      var str="<option value='渝中'>渝中</option><option value='江北'>江北</option><option value='南岸'>南岸</option><option value='沙坪坝'>沙坪坝</option><option value='万州'>万州</option>";
	   }
	   else if($("#stayCity_province").val()=='江苏')
	   {
	      var str="<option value='南京'>南京</option><option value='无锡'>无锡</option><option value='徐州'>徐州</option><option value='常州'>常州</option><option value='苏州'>苏州</option>";
	   }
	   else if($("#stayCity_province").val()=='浙江')
	   {
	      var str="<option value='杭州'>杭州</option><option value='宁波'>宁波</option><option value='温州'>温州</option><option value='嘉兴'>嘉兴</option><option value='绍兴'>绍兴</option>";
	   } 
	   else if($("#stayCity_province").val()=='广东')
	   {
	      var str="<option value='广州'>广州</option><option value='深圳'>深圳</option><option value='东莞'>东莞</option><option value='佛山'>佛山</option><option value='珠海'>珠海</option>";
	   }
	   else if($("#stayCity_province").val()=='福建')
	   {
	      var str="<option value='福州'>福州</option><option value='厦门'>厦门</option><option value='泉州'>泉州</option><option value='莆田'>莆田</option><option value='龙岩'>龙岩</option>";
	   }
	   else if($("#stayCity_province").val()=='山东')
	   {
	      var str="<option value='济南'>济南</option><option value='青岛'>青岛</option><option value='烟台'>烟台</option><option value='日照'>日照</option><option value='莱芜'>莱芜</option>";
	   }
	   else if($("#stayCity_province").val()=='辽宁')
	   {
	      var str="<option value='沈阳'>沈阳</option><option value='大连'>大连</option><option value='抚顺'>抚顺</option><option value='锦州'>锦州</option><option value='莱芜'>莱芜</option>";
	   }
	   else if($("#stayCity_province").val()=='内蒙古')
	   {
	      var str="<option value='呼和浩特'>呼和浩特</option><option value='包头'>包头</option><option value='呼伦贝尔'>呼伦贝尔</option><option value='赤峰'>赤峰</option><option value='鄂尔多斯'>鄂尔多斯</option>";
	   }
	   
	   $("#stayCity_city").append(str);
	}
   
   function change_province2()
	{
	   $("#hometown_city").empty();
	   if($("#hometown_province").val()=='北京')
	   {
	      var str="<option value='东城'>东城</option><option value='西城'>西城</option><option value='朝阳'>朝阳</option><option value='海淀'>海淀</option><option value='昌平'>昌平</option>";
	   }
	   else if($("#hometown_province").val()=='上海')
	   {
	      var str="<option value='黄埔'>黄埔</option><option value='虹口'>虹口</option><option value='宝山'>宝山</option><option value='嘉定'>嘉定</option><option value='浦东新区'>浦东新区</option>";
	   }
	   else if($("#hometown_province").val()=='天津')
	   {
	      var str="<option value='和平'>和平</option><option value='河东'>河东</option><option value='河西'>河西</option><option value='南开'>南开</option><option value='津南'>津南</option>";
	   } 
	   else if($("#hometown_province").val()=='重庆')
	   {
	      var str="<option value='渝中'>渝中</option><option value='江北'>江北</option><option value='南岸'>南岸</option><option value='沙坪坝'>沙坪坝</option><option value='万州'>万州</option>";
	   }
	   else if($("#hometown_province").val()=='江苏')
	   {
	      var str="<option value='南京'>南京</option><option value='无锡'>无锡</option><option value='徐州'>徐州</option><option value='常州'>常州</option><option value='苏州'>苏州</option>";
	   }
	   else if($("#hometown_province").val()=='浙江')
	   {
	      var str="<option value='杭州'>杭州</option><option value='宁波'>宁波</option><option value='温州'>温州</option><option value='嘉兴'>嘉兴</option><option value='绍兴'>绍兴</option>";
	   } 
	   else if($("#hometown_province").val()=='广东')
	   {
	      var str="<option value='广州'>广州</option><option value='深圳'>深圳</option><option value='东莞'>东莞</option><option value='佛山'>佛山</option><option value='珠海'>珠海</option>";
	   }
	   else if($("#hometown_province").val()=='福建')
	   {
	      var str="<option value='福州'>福州</option><option value='厦门'>厦门</option><option value='泉州'>泉州</option><option value='莆田'>莆田</option><option value='龙岩'>龙岩</option>";
	   }
	   else if($("#hometown_province").val()=='山东')
	   {
	      var str="<option value='济南'>济南</option><option value='青岛'>青岛</option><option value='烟台'>烟台</option><option value='日照'>日照</option><option value='莱芜'>莱芜</option>";
	   }
	   else if($("#hometown_province").val()=='辽宁')
	   {
	      var str="<option value='沈阳'>沈阳</option><option value='大连'>大连</option><option value='抚顺'>抚顺</option><option value='锦州'>锦州</option><option value='莱芜'>莱芜</option>";
	   }
	   else if($("#hometown_province").val()=='内蒙古')
	   {
	      var str="<option value='呼和浩特'>呼和浩特</option><option value='包头'>包头</option><option value='呼伦贝尔'>呼伦贝尔</option><option value='赤峰'>赤峰</option><option value='鄂尔多斯'>鄂尔多斯</option>";
	   }
	   
	   $("#hometown_city").append(str);
	}
	
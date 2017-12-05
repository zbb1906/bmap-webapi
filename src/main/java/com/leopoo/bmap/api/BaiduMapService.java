package com.leopoo.bmap.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.leopoo.bmap.API;
import com.leopoo.bmap.AbstractBaiduMap;
import com.leopoo.bmap.http.HttpParams;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class BaiduMapService extends AbstractBaiduMap {


  public BaiduMapService(String ak) {
    super(ak);
  }

  public Map<String, String> geocode(String address, String city) {
    assert StringUtils.isNotEmpty(address) : "待解析的地址不能为空字符串";
    HttpParams http = get().put("output", "json");  //设置返回json
    http.put("address", address);
    if (StringUtils.isNotEmpty(city)) {
      http.put("city", city);
    }
    try {
      String result = http.send2String(API.GEOCODE.getUrl());
      JSONObject json = JSON.parseObject(result);
    } catch (Exception e) {
    }
    return null;
  }
}

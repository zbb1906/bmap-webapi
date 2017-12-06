package com.leopoo.bmap.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.leopoo.bmap.API;
import com.leopoo.bmap.AbstractBaiduMap;
import com.leopoo.bmap.Status;
import com.leopoo.bmap.http.HttpParams;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class BaiduMapService extends AbstractBaiduMap {


  public BaiduMapService(String ak) {
    super(ak);
  }

  public Map<String, String> geocode(String address, String city) throws Exception {
    assert StringUtils.isNotEmpty(address) : "待解析的地址不能为空字符串";
    HttpParams http = get().put("output", "json");  //设置返回json
    http.put("address", address);
    if (StringUtils.isNotEmpty(city)) {
      http.put("city", city);
    }
    String result = http.send2String(API.GEOCODE.getUrl());
    JSONObject json = JSON.parseObject(result);
    int status = json.getInteger("status");
    if (status == Status.OK.getStatus()) {  // 查询成功
      Map<String, String> map = new HashMap<>();
      JSONObject location = json.getJSONObject("result").getJSONObject("location");
      map.put("lat", location.getString("lat"));
      map.put("lng", location.getString("lng"));
      return map;
    } else {
      log.info("地址:{},查询失败:{}", address, Status.getMessage(status));
      return null; // 查询失败
    }
  }
}

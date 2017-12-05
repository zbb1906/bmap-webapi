package com.leopoo.test;


import com.leopoo.bmap.IBaiduMap;
import com.leopoo.bmap.api.BaiduMapService;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class BaiduMapCase {


  IBaiduMap baiduMap;

  @Before
  public void init() {
    baiduMap = new BaiduMapService("FGG3qvvQHS0etsmHkqGIfVGsZWR0T92d");
  }


  @Test
  public void geocode() throws Exception {
    String address = "四川省成都市";
    Map<String, String> map = baiduMap.geocode(address, null);
    System.out.println(address + "经纬度\t" + map.get("lat") + "\t" + map.get("lng"));
  }
}

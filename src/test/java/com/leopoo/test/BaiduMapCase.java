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
    String address = "四川省成都市双流县华阳镇街道半边街社区";
    Map<String, String> map = baiduMap.geocode(address, null);
    System.out.println(address + "经纬度\t" + map.get("lat") + "\t" + map.get("lng"));
    String address1 = "四川省成都市双流县华阳镇街道姐儿堰社区";
    Map<String, String> map1 = baiduMap.geocode(address1, null);
    System.out.println(address1 + "经纬度\t" + map1.get("lat") + "\t" + map1.get("lng"));
  }
}

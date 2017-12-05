package com.leopoo.test;


import com.leopoo.bmap.IBaiduMap;
import com.leopoo.bmap.api.BaiduMapService;
import org.junit.Before;
import org.junit.Test;

public class BaiduMapCase {


  IBaiduMap baiduMap;

  @Before
  public void init() {
    baiduMap = new BaiduMapService("FGG3qvvQHS0etsmHkqGIfVGsZWR0T92d");
  }


  @Test
  public void geocode() {
    try {
      baiduMap.geocode("四川省成都市", null);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

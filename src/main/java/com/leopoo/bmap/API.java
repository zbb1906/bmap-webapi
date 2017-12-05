package com.leopoo.bmap;

import lombok.Getter;

@Getter
public enum API {

  //正\逆地址解析接口
  GEOCODE("http://api.map.baidu.com/geocoder/v2/");

  private String url;

  API(String url) {
    this.url = url;
  }

}

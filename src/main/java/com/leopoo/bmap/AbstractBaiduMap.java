package com.leopoo.bmap;


import com.leopoo.bmap.http.HttpGetParams;
import com.leopoo.bmap.http.HttpParams;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractBaiduMap implements IBaiduMap {

  /**
   * 百度地图AK
   */
  public String ak;

  public AbstractBaiduMap(String ak) {
    this.ak = ak;
  }

  /**
   * 获取http 请求实例
   */
  public HttpParams get() {
    return new HttpGetParams().put("ak", ak);
  }

  public String getAk() {
    return ak;
  }

}

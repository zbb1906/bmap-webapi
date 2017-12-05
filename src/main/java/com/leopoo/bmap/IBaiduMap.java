package com.leopoo.bmap;

import java.util.Map;

public interface IBaiduMap {

  /**
   * 正向地址解析 获取经纬度
   *
   * @param address 待解析的地址。最多支持84个字节。 可以输入三种样式的值，分别是： <br/> 1、标准的结构化地址信息，如北京市海淀区上地十街十号
   * 【推荐，地址结构越完整，解析精度越高】<br/> 2、支持“*路与*路交叉口”描述方式，如北一环路和阜阳路的交叉路口 第二种方式并不总是有返回结果，只有当地址库中存在该地址描述时才有返回。
   * @param city 城市
   * @return map.lat 纬度值 map.lng 经度值 如果为null 说明查询失败
   */
  Map<String, String> geocode(String address, String city) throws Exception;
}

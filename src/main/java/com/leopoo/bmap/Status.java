package com.leopoo.bmap;

import lombok.Getter;

/**
 * 服务状态码
 */
@Getter
public enum Status {

  OK(0, "请求成功"),
  FAILED(1, "服务器内部错误"),
  INVALID(2, "请求参数非法"),   //必要参数拼写错误或漏传（如query和tag请求中均未传入）
  VERIFY(3, "权限校验失败"),
  QUOTA(4, "配额校验失败"),   //服务当日调用次数已超限，请前往API控制台提升（请优先进行开发者认证）
  AK(5, "ak不存在或者非法"),   //未传入ak参数；ak已被删除（可前往回收站恢复）；
  F101(101, "服务禁用"),
  F102(102, "不通过白名单或者安全码不对"),
  F2XX(200, "无权限"),
  F3XX(300, "配额错误");

  private int status;
  private String message;

  Status(int status, String message) {
    this.message = message;
    this.status = status;
  }

  public static String getMessage(int status) {
    for (Status s : Status.values()) {
      if (s.getStatus() == status) {
        return s.getMessage();
      }
    }
    // 如果错误码 在200 和300 之间
    if (Status.F2XX.getStatus() >= status && Status.F3XX.getStatus() < 300) {
      return Status.F2XX.getMessage();
    } else {    // 如果都不在
      return Status.F3XX.getMessage();
    }
  }
}
package com.restfulproject.team3.base.exception;

/**
 * 该类用于统一管理错误返回信息<br>
 * 下面errCode已经被占用
 * <li>60000~69999: Admin Error Response</>
 */
public enum ErrorResponse {

  // general error
  PARAM_VALIDATION_ERROR(00001, "参数不合法"),
  DATA_NOT_FOUND(00002, "未在系统中维护"),
  FREEMARKER_ERROR(00003, "freemarker合并模板出现异常！"),
  EMAIL_ERROR(00004, "email发送出现异常！"),
  DATA_EXISTED(00005, "已在系统中维护"),
  LDAP_ERROR(5, "ldap出现异常"),

  USER_NOT_EXIST(10001, "用户不存在"),

  // user error
  SYS_INTERNAL_ERR(20001, "系统内部错误"),

  // data invalid error
  DATA_INVALID(00003, "数据不可用"),

  // admin module error response
  USER_NOT_FOUND_ERROR(60000, "User not found by id!"),
  USERNAME_OCCUPIED_ERROR(60003, "username have been occupied"),
  PHONE_OCCUPIED_ERROR(60004, "phone have been occupied"),
  EMAIL_OCCUPIED_ERROR(60005, "email have been occupied"),
  EMAIL_CHECK_CODE_ERROR(60006, "email check code invalid!"),
  PHONE_CHECK_CODE_ERROR(60007, "phone check code invalid!");

  private int code;
  private String message;

  private ErrorResponse(int code, String message) {
    this.code = code;
    this.message = message;
  }

  @Override
  public String toString() {
    return "ErrorResponse{" + "code=" + code + ", message='" + message + '\'' + '}';
  }

  public int getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}

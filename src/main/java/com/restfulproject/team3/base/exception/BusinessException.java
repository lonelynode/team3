package com.restfulproject.team3.base.exception;

import javax.annotation.Nonnull;

/**
 * 自定义业务异常，<br>
 * 建议用法：
 *
 * <pre>
 *  public class DataNotFoundException extends BusinessException{
 *      // 构造函数
 *      public DataNotFoundException(){
 *          super(ErrorResponse.DATA_NOT_FOUND.getCode(),ErrorResponse.DATA_NOT_FOUND.getMessage());
 *      }
 *  }
 *
 * </pre>
 *
 */
public class BusinessException extends RuntimeException {
  private int code;

  /**
   * 感觉各个模块用继承的方式比较好，针对性的异常名字更加容易理解。比如RegisterException就代表Register的错误。
   *
   * @param errorResponse
   */
  public BusinessException(ErrorResponse errorResponse) {
    super(errorResponse.getMessage());
    this.code = errorResponse.getCode();
  }

  public BusinessException(ErrorResponse errorResponse, String message) {
    super(message);
    this.code = errorResponse.getCode();
  }

  /**
   * 对于不需要返回给前端的异常，可以不添加code
   *
   * @param message
   */
  public BusinessException(@Nonnull String message) {
    super(message);
  }

  public BusinessException(int code, @Nonnull String message) {
    super(message);
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }
}

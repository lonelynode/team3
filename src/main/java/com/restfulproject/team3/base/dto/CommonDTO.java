package com.restfulproject.team3.base.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommonDTO {
  private String id;
  private String createBy;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private LocalDateTime createTime;
  private String updateBy;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private LocalDateTime updateTime;

  public CommonDTO() {};

  public CommonDTO(
      String id,
      String createBy,
      LocalDateTime createTime,
      String updateBy,
      LocalDateTime updateTime) {
    this.id = id;
    this.createBy = createBy;
    this.createTime = createTime;
    this.updateBy = updateBy;
    this.updateTime = updateTime;
  }
}

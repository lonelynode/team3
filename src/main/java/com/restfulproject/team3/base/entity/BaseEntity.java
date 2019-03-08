package com.restfulproject.team3.base.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

// TODO: 对于审计问题， Hibernate Envers 可能是一个更好的选择
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {
  @Column(length = 1)
  private Integer isActive;
    private String createBy;
    //    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Column(length = 6)
    private Date createTime;
    private String updateBy;
    //    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public BaseEntity() {
        this.isActive = 1;
    }

    public BaseEntity(String createdBy) {
        this.isActive = 1;
        this.createBy = createdBy;
        this.createTime = new Date();
    }
}

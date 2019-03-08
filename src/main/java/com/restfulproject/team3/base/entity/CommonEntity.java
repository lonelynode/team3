package com.restfulproject.team3.base.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class CommonEntity implements Serializable {
  @Id
  @GeneratedValue(generator = "JPA-UUID")
  @GenericGenerator(name = "JPA-UUID", strategy = "uuid")
  @Column(name = "UUID", nullable = false, columnDefinition = "char(32)")
  private String id;

  @CreatedDate
  @Column(name = "CREATE_TIME", updatable = false)
  private LocalDateTime createTime;

  @CreatedBy
  @Column(name = "CREATE_BY", updatable = false)
  private String createBy;

  @LastModifiedDate
  @Column(name = "UPDATE_TIME")
  private LocalDateTime updateTime;

  @LastModifiedBy
  @Column(name = "UPDATE_BY")
  private String updateBy;

  @Version private Long version;

  public CommonEntity() {
    super();
  }
}

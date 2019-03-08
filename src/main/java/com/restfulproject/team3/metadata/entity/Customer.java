package com.restfulproject.team3.metadata.entity;

import com.restfulproject.team3.base.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "test_customer")
public class Customer extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "JPA-UUID")
    @GenericGenerator(name = "JPA-UUID", strategy = "uuid")
    @Column(name = "UUID", nullable = false, columnDefinition = "char(32)")
    private String id;
    private String name;
    private String address;
}

package com.restfulproject.team3.base.service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface BaseService<T, ID> {

    T save(T t);
    List<T> findAll();
    Page<T> findAll(int page, int size);
    T getById(ID id);
    T findByIdAndIsActive(ID id, Integer isActive);
    List<T> findAllByIsActive(Integer isActive);
    Page<T> findAllByIsActive(Integer isActive, int page, int size);
    Page<T> findAllByKeyword(Example<T> example, int page, int size, Sort sort);
}

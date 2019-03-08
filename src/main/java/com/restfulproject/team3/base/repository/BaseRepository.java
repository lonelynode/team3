package com.restfulproject.team3.base.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T,ID> {

    T findByIdAndIsActive(ID id, Integer isActive);
    List<T> findAllByIsActive(Integer isActive);
    Page<T> findAllByIsActive(Integer isActive, Pageable pageable);
}

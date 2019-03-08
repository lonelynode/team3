package com.restfulproject.team3.base.service;

import com.restfulproject.team3.base.constant.ActiveStatus;
import com.restfulproject.team3.base.repository.BaseRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class BaseServiceImpl<T, ID> implements BaseService<T, ID> {

    private BaseRepository<T, ID> baseRepository;

    public BaseServiceImpl(BaseRepository<T, ID> baseRepository){
        this.baseRepository = baseRepository;
    }

    @Override
    public T save(T t) {
        return baseRepository.save(t);
    }

    @Override
    public List<T> findAll() {
        return baseRepository.findAllByIsActive(ActiveStatus.ACTIVE);
    }

    @Override
    public Page<T> findAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return baseRepository.findAllByIsActive(ActiveStatus.ACTIVE, pageRequest);
    }

    @Override
    public T getById(ID id) {
        return baseRepository.findById(id).orElse(null);
    }

    @Override
    public T findByIdAndIsActive(ID id, Integer isActive) {
        return baseRepository.findByIdAndIsActive(id, isActive);
    }

    @Override
    public List<T> findAllByIsActive(Integer isActive) {
        return baseRepository.findAllByIsActive(isActive);
    }

    @Override
    public Page<T> findAllByIsActive(Integer isActive, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page,size);
        return baseRepository.findAllByIsActive(isActive, pageRequest);
    }

    @Override
    public Page<T> findAllByKeyword(Example<T> example, int page, int size, Sort sort) {
        PageRequest pageRequest = PageRequest.of(page,size, sort);
        return baseRepository.findAll(example,pageRequest);
    }
}

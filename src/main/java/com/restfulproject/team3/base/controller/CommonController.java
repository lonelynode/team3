package com.restfulproject.team3.base.controller;

import com.restfulproject.team3.base.constant.ActiveStatus;
import com.restfulproject.team3.base.entity.BaseEntity;
import com.restfulproject.team3.base.exception.BusinessException;
import com.restfulproject.team3.base.exception.ErrorResponse;
import com.restfulproject.team3.base.service.BaseService;
import com.restfulproject.team3.base.util.UpdateTool;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommonController<T extends BaseEntity, ID> {
    private BaseService<T, ID> baseService;
    private String type;
    public ExampleMatcher exampleMatcher;

    public CommonController(BaseService<T, ID> baseService, String type, ExampleMatcher exampleMatcher){
        this.baseService = baseService;
        this.type = type;
        this.exampleMatcher = exampleMatcher;
    }

    @GetMapping("/{id}")
    public T findById(@PathVariable ID id) throws BusinessException {
        T t = baseService.findByIdAndIsActive(id, ActiveStatus.ACTIVE);
        if (t == null) {
            throw new BusinessException(ErrorResponse.DATA_NOT_FOUND, this.type + "not exist");
        }
        return t;
    }

    @GetMapping
    public Object findAll(@Param("page")String page, @Param("size")String size) throws BusinessException{
        if(StringUtils.isEmpty(page) || StringUtils.isEmpty(size) ){
            return baseService.findAllByIsActive(ActiveStatus.ACTIVE);
        }
        return baseService.findAllByIsActive(ActiveStatus.ACTIVE ,Integer.parseInt(page), Integer.parseInt(size));
    }

    @PostMapping
    public T save(@RequestBody T t) throws BusinessException {
        t.setCreateTime(new Date());
        baseService.save(t);
        return t;
    }

    @PostMapping("/{id}")
    public T update(@PathVariable ID id, @RequestBody T t) throws BusinessException {
        T oldT= baseService.getById(id);
        if (oldT.getIsActive() == ActiveStatus.NOT_ACTIVE) {
            throw new BusinessException(ErrorResponse.DATA_INVALID, this.type + " is exist but status is invalid you can change the status to active");
        }
        UpdateTool.copyNullProperties(oldT, t);
        t.setUpdateTime(new Date());
        baseService.save(t);
        return t;
    }

    @PostMapping("/search")
    public Page<T> search(@RequestBody T t, @Param("page")String page, @Param("size")String size, @RequestParam(value = "sortBy", required = false)String sortBy, @RequestParam(value = "direction", required = false)String direction) throws BusinessException {
      t.setIsActive(ActiveStatus.ACTIVE);
        Example<T> ex = Example.of(t,this.exampleMatcher);
        List<Sort.Order> orderList = new ArrayList<>();
        Sort.Order order = null;
        if(!StringUtils.isEmpty(sortBy) && !StringUtils.isEmpty(direction)){
            if(Integer.parseInt(direction) == 1){
                order = new Sort.Order(Sort.Direction.ASC,sortBy);
            }else{
                order = new Sort.Order(Sort.Direction.DESC,sortBy);
            }
            orderList.add(order);
        }
        Sort.Order orderById = new Sort.Order(Sort.Direction.ASC, "id");
        orderList.add(orderById);
        Sort sort = Sort.by(orderList);
        return baseService.findAllByKeyword(ex, Integer.parseInt(page), Integer.parseInt(size),sort);
    }

    @PutMapping(value = "/{id}")
    public T activeTrade(@PathVariable ID id) throws BusinessException {
        T t = baseService.findByIdAndIsActive(id, ActiveStatus.NOT_ACTIVE);
        if (t == null) {
            throw new BusinessException(ErrorResponse.DATA_INVALID, this.type + " is not exist or ectTrade is active");
        }
        t.setIsActive(ActiveStatus.ACTIVE);
        baseService.save(t);
        return t;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable ID id) throws BusinessException{
        T t = baseService.findByIdAndIsActive(id, ActiveStatus.ACTIVE);
        if (t == null) {
            throw new BusinessException(ErrorResponse.DATA_INVALID, this.type + " is not exist or "+ this.type + " is not active");
        }
        t.setIsActive(ActiveStatus.NOT_ACTIVE);
        baseService.save(t);
        return "delete " + this.type + " which id is " + id + "success";
    }
}

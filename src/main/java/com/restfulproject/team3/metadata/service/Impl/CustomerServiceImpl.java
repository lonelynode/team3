package com.restfulproject.team3.metadata.service.Impl;

import com.restfulproject.team3.base.service.BaseServiceImpl;
import com.restfulproject.team3.metadata.entity.Customer;
import com.restfulproject.team3.metadata.repository.CustomerRepository;
import com.restfulproject.team3.metadata.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl extends BaseServiceImpl<Customer,String> implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    CustomerServiceImpl(@Autowired CustomerRepository customerRepository){
        super(customerRepository);
    }

}

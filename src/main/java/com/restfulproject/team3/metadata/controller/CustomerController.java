package com.restfulproject.team3.metadata.controller;


import com.restfulproject.team3.base.controller.CommonController;
import com.restfulproject.team3.metadata.entity.Customer;
import com.restfulproject.team3.metadata.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController extends CommonController<Customer,String> {
    @Autowired
    private CustomerService customerService;
    CustomerController(@Autowired CustomerService customerService){
        super(customerService,"customer",ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase(true)
                .withIgnorePaths("version"));
    }
}

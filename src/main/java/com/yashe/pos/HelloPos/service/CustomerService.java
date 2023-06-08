package com.yashe.pos.HelloPos.service;

import com.yashe.pos.HelloPos.dto.request.RequestCustomerDto;
import com.yashe.pos.HelloPos.dto.response.ResponseCustomerDto;
import com.yashe.pos.HelloPos.dto.response.pagginated.model.CustomerResponsePagginatedDto;

import java.util.List;

public interface CustomerService {
    public ResponseCustomerDto saveCustomer(RequestCustomerDto dto);
    public ResponseCustomerDto findCustomer(int id) ;
    public ResponseCustomerDto updateCustomer(RequestCustomerDto dto, int id) ;
    public String deleteCustomer(int id);
    public CustomerResponsePagginatedDto findAllCustomers(int page, int size, String text);
}

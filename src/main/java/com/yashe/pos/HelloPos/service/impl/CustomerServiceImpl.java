package com.yashe.pos.HelloPos.service.impl;

import com.yashe.pos.HelloPos.dto.request.RequestCustomerDto;
import com.yashe.pos.HelloPos.dto.response.ResponseCustomerDto;
import com.yashe.pos.HelloPos.dto.response.pagginated.model.CustomerResponsePagginatedDto;
import com.yashe.pos.HelloPos.entity.Customer;
import com.yashe.pos.HelloPos.execption.EntryNotFoundException;
import com.yashe.pos.HelloPos.repo.CustomerRepo;
import com.yashe.pos.HelloPos.service.CustomerService;
import com.yashe.pos.HelloPos.util.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerRepo customerRepo;
    CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo, CustomerMapper customerMapper) {
        this.customerRepo = customerRepo;
        this.customerMapper = customerMapper;
    }

    @Override
    public ResponseCustomerDto saveCustomer(RequestCustomerDto dto) {
        Customer savedCustomer = customerRepo.save(customerMapper.toCustomerEntity(dto));
        return customerMapper.toCustomerResponseDto(savedCustomer);
    }

    @Override
    public ResponseCustomerDto findCustomer(int id) {
        Customer customerById = customerRepo.findCustomerById(id);
        if (null != customerById) {
            return customerMapper.toCustomerResponseDto(customerById);
        } else {
            throw new EntryNotFoundException("Cannot find customer!");
        }
    }

    @Override
    public ResponseCustomerDto updateCustomer(RequestCustomerDto dto, int id) {
        Customer customerById = customerRepo.findCustomerById(id);
        if (null != customerById) {
            return customerMapper.toCustomerResponseDto(
                    customerRepo.save(customerMapper.toCustomerEntity(dto))
            );
        }
        throw new EntryNotFoundException("Customer Cant Find!");
    }

    @Override
    public String deleteCustomer(int id) {
        Customer customerById = customerRepo.findCustomerById(id);
        if (null != customerById) {
            customerRepo.delete(customerById);
            return id + " is deleted";
        } else {
            throw new EntryNotFoundException("Cant Find Customer!");
        }
    }

    @Override
    public CustomerResponsePagginatedDto findAllCustomers(int page, int size, String searchTxt) {
        System.out.println("--------------------------  hi -----------------");
        List<Customer> allByNameOrAddress = customerRepo.findAllByNameOrAddress(searchTxt, PageRequest.of(page, size));
        List<ResponseCustomerDto> responseCustomerDtos = customerMapper.toResponseCustomersList(allByNameOrAddress);
        int count = customerRepo.countDataWithSearchText(searchTxt);
        return new CustomerResponsePagginatedDto(
                count,
                responseCustomerDtos
        );
    }
}

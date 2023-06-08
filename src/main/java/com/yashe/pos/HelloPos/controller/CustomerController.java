package com.yashe.pos.HelloPos.controller;

import com.yashe.pos.HelloPos.dto.request.RequestCustomerDto;
import com.yashe.pos.HelloPos.dto.response.ResponseCustomerDto;
import com.yashe.pos.HelloPos.dto.response.pagginated.model.CustomerResponsePagginatedDto;
import com.yashe.pos.HelloPos.service.CustomerService;
import com.yashe.pos.HelloPos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/save") //http://localhost:8000/api/v1/customers/save
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody RequestCustomerDto customerDto) {
        ResponseCustomerDto responseCustomerDto = customerService.saveCustomer(customerDto);
        return new ResponseEntity<StandardResponse>(new StandardResponse(
                201, "Saved New Customer Successfully", responseCustomerDto
        ), HttpStatus.CREATED);
    }

    @PutMapping(value = "/modify", params = {"id"}) //http://localhost:8000/api/v1/customers/modify
    public ResponseEntity<StandardResponse> updateCustomer(@RequestBody RequestCustomerDto customerDto, @RequestParam(value = "id") int id) {
        ResponseCustomerDto responseCustomerDto = customerService.updateCustomer(customerDto, id);
        return new ResponseEntity<StandardResponse>(new StandardResponse(
                201, "Updated Customer Successfully", responseCustomerDto
        ), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> findCustomer(@PathVariable int id) throws ClassNotFoundException {
        ResponseCustomerDto customer = customerService.findCustomer(id);
        return new ResponseEntity<StandardResponse>(new StandardResponse(
                200, "Found Customer", customer
        ), HttpStatus.OK);
    }

    @GetMapping(
            value = {"/list"},
            params = {"page", "size", "searchCount"}
    )
    public ResponseEntity<StandardResponse> findAllCustomers(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size,
            @RequestParam(value = "searchCount") String searchText
    ) {
        CustomerResponsePagginatedDto allCustomers = customerService.findAllCustomers(page, size, searchText);
        return new ResponseEntity<StandardResponse>(new StandardResponse(
                200,
                "Find All",
                allCustomers
        ),HttpStatus.OK);
    }

    @DeleteMapping(value = "/remove", params = {"id"})
    public String deleteCustomer(@RequestParam String id) {
        return id;
    }

}

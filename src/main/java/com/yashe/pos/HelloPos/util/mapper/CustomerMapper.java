package com.yashe.pos.HelloPos.util.mapper;

import com.yashe.pos.HelloPos.dto.request.RequestCustomerDto;
import com.yashe.pos.HelloPos.dto.response.ResponseCustomerDto;
import com.yashe.pos.HelloPos.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    ResponseCustomerDto toCustomerResponseDto(Customer customer);
    Customer toCustomerEntity(RequestCustomerDto requestCustomerDto);
    List<ResponseCustomerDto> toResponseCustomersList(List<Customer> customers);
}

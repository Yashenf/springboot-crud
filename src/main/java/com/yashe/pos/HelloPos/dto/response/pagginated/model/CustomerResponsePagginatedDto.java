package com.yashe.pos.HelloPos.dto.response.pagginated.model;

import com.yashe.pos.HelloPos.dto.response.ResponseCustomerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerResponsePagginatedDto {
    private int dataCount;
    private List<ResponseCustomerDto> list;
}

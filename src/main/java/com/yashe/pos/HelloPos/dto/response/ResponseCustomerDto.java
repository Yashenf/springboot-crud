package com.yashe.pos.HelloPos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseCustomerDto {
    private int id;
    private String name;
    private String address;
    private double salary;
}

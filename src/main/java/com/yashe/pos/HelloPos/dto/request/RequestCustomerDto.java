package com.yashe.pos.HelloPos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestCustomerDto {
    private String name;
    private String address;
    private long salary;
}

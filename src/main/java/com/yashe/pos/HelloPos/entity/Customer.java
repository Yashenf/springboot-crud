package com.yashe.pos.HelloPos.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Customer {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int id;
    private String name;
    private String address;
    private long salary;
}

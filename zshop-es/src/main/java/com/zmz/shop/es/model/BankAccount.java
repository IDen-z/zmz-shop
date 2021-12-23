package com.zmz.shop.es.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {

    private Long accountNumber;

    private String address;

    private Long age;

    private String city;

    private String email;

    private String employer;

    private String firstname;

    private String gender;

    private String lastname;

    private String state;


}


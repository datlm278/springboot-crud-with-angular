package com.example.springbootcrudwithangular.dto.response;

import lombok.Data;

@Data
public class EmployeeResponse {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private Long status;
    private Long organizationId;
    private String organizationName;
}

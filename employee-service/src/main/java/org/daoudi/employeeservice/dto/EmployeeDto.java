package org.daoudi.employeeservice.dto;

import lombok.*;

@Getter
@Setter
public class EmployeeDto {
    private Long id;
    private String name;
    private String position;
    private Long departmentId;
    private int age;
}

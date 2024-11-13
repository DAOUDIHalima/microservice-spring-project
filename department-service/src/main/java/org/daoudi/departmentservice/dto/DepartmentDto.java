package org.daoudi.departmentservice.dto;

import lombok.Getter;
import lombok.Setter;
import org.daoudi.departmentservice.model.Employee;

import java.util.List;

@Getter
@Setter
public class DepartmentDto {
    private Long id;
    private String name;
    private List<Employee> employees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and setter for employees
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }


}

package org.daoudi.departmentservice.feign;

import org.daoudi.departmentservice.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "employee-service")
public interface EmployeeClient {
    @GetMapping("/employee/{departmentId}")
    List<Employee> findByDepartmentId(@PathVariable("departmentId") Long id);
}


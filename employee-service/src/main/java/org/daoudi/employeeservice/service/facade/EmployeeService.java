package org.daoudi.employeeservice.service.facade;

import org.daoudi.employeeservice.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto findById(Long id);

    List<EmployeeDto> findAll();

    EmployeeDto save(EmployeeDto employeeDto);

    void delete(Long id);

    List<EmployeeDto> findByDepartmentId(Long departmentId);
}

package org.daoudi.departmentservice.service.facade;

import org.daoudi.departmentservice.dto.DepartmentDto;
import org.daoudi.departmentservice.model.Department;
import org.daoudi.departmentservice.model.Employee;

import java.util.List;

public interface DepartmentService {
    DepartmentDto findById(Long id) ;

    List<DepartmentDto> findAll();

    DepartmentDto save(DepartmentDto departmentDto);

    void delete(Long id);

    List<DepartmentDto> findAllWithEmployees();
}

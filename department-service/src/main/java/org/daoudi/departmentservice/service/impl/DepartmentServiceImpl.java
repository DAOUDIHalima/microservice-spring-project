package org.daoudi.departmentservice.service.impl;

import org.daoudi.departmentservice.controller.DepartmentController;
import org.daoudi.departmentservice.dto.DepartmentDto;
import org.daoudi.departmentservice.feign.EmployeeClient;
import org.daoudi.departmentservice.model.Department;
import org.daoudi.departmentservice.model.Employee;
import org.daoudi.departmentservice.repository.DepartmentRepository;
import org.daoudi.departmentservice.service.facade.DepartmentService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmployeeClient employeeClient;
    @Autowired
    private static Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Override
    public DepartmentDto findById(Long id) {
        return modelMapper.map(departmentRepository.findById(id), DepartmentDto.class);
    }

    @Override
    public List<DepartmentDto> findAll() {
        List<DepartmentDto> departmentDtos = new ArrayList();
        List<Department> departments = departmentRepository.findAll();
        for (Department department : departments) {
            departmentDtos.add(modelMapper.map(department, DepartmentDto.class));
        }
        return departmentDtos;
    }

    @Override
    public DepartmentDto save(DepartmentDto departmentDto) {

        return modelMapper.map(departmentRepository.save(modelMapper.map(departmentDto, Department.class)), DepartmentDto.class);
    }

    @Override
    public void delete(Long id) {
       departmentRepository.findById(id);
    }

    @Override
    public List<DepartmentDto> findAllWithEmployees() {
        List<DepartmentDto> departments = this.findAll();
        departments.forEach(department -> {
            try {
                List<Employee> employees = employeeClient.findByDepartmentId(department.getId());
                department.setEmployees(employees);
            } catch (Exception e) {
                LOGGER.error("Error fetching employees for department ID " + department.getId(), e);
            }
        });
        return departments;
    }



}

package org.daoudi.employeeservice.controller;

import org.daoudi.employeeservice.dto.EmployeeDto;
import org.daoudi.employeeservice.service.impl.EmployeeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private static Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDto findById(@PathVariable Long id) {
        LOGGER.info("employee find");
        return employeeService.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeDto> findAll() {
        LOGGER.info("employee find All");
        return employeeService.findAll();
    }


    @GetMapping("/employee/{departmentId}")
    public List<EmployeeDto> findByDepartment(@PathVariable Long departmentId) {
        LOGGER.info("employee find by department");
        return employeeService.findByDepartmentId(departmentId);
    }

    @PostMapping(value ="/emp", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        LOGGER.info("Creating employee with data: {}", employeeDto);
        EmployeeDto savedEmployee = employeeService.save(employeeDto);
        LOGGER.info("Saved employee data: {}", savedEmployee);
        return savedEmployee;
    }

    @DeleteMapping("/{id}")
    public void deleteemployee(@PathVariable Long id){
        employeeService.delete(id);
    }



}

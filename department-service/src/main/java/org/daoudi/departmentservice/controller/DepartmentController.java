package org.daoudi.departmentservice.controller;


import org.daoudi.departmentservice.dto.DepartmentDto;
import org.daoudi.departmentservice.model.Department;
import org.daoudi.departmentservice.service.facade.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;



    @Autowired
    private static Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DepartmentDto findById(@PathVariable Long id) {
        LOGGER.info("Department find");
        return departmentService.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DepartmentDto> findAll() {
        LOGGER.info("Department find All");
        return departmentService.findAll();
    }


    @PostMapping(value = "/dep", produces = MediaType.APPLICATION_JSON_VALUE)
    public DepartmentDto createDepartment(@RequestBody DepartmentDto departmentDto) {
        LOGGER.info("Department created");
        return departmentService.save(departmentDto);
    }


    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id){
        departmentService.delete(id);
    }

    @GetMapping("/with-employees")
    public List<DepartmentDto> findAllWithEmployees() {
        LOGGER.info("Department find");
       return departmentService.findAllWithEmployees();
    }
}

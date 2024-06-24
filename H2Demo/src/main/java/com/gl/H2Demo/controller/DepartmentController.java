package com.gl.H2Demo.controller;

import com.gl.H2Demo.entity.Department;
import com.gl.H2Demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/dept")
    public Department saveDept(@RequestBody Department department){
        return departmentService.saveDept(department);
    }

    @GetMapping("/dept")
    public List<Department> fetchDeptList(){
        return departmentService.fetchDeptList();
    }

    @PutMapping("/dept/{id}")
    public Department updateDept(@RequestBody Department department, @PathVariable("id") Long Id){
        return departmentService.updateDept(department,Id);
    }

    @DeleteMapping("/dept/{id}")
    public String deleteDeptById(@PathVariable("id") Long id){
        departmentService.deleteDeptById(id);
        return "Deleted Successfully";
    }
}

package com.gl.H2Demo.service;

import com.gl.H2Demo.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentService {
    public Department saveDept(Department department);
    public List<Department> fetchDeptList();
    public Department updateDept(Department department,Long deptId);
    public void deleteDeptById(Long deptId);
}

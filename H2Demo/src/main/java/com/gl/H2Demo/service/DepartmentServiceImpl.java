package com.gl.H2Demo.service;

import com.gl.H2Demo.entity.Department;
import com.gl.H2Demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDept(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDeptList() {
        return (List<Department>) departmentRepository.findAll();
    }

    @Override
    public Department updateDept(Department department, Long deptId) {
        Department deptDB=departmentRepository.findById(deptId).get();

        if(Objects.nonNull(department.getDeptName()) && !"".equalsIgnoreCase(department.getDeptName())){
            deptDB.setDeptName(department.getDeptName());
        }

        if(Objects.nonNull(department.getDeptAddress()) && !"".equalsIgnoreCase(department.getDeptAddress())){
            deptDB.setDeptAddress(department.getDeptAddress());
        }

        if(Objects.nonNull(department.getDeptCode()) && !"".equalsIgnoreCase(department.getDeptCode())){
            deptDB.setDeptCode(department.getDeptCode());
        }

        return departmentRepository.save(deptDB);
    }

    @Override
    public void deleteDeptById(Long deptId) {
        departmentRepository.deleteById(deptId);
    }
}

package com.vvv.department.service;

import com.vvv.department.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    DepartmentDTO createDepartment(DepartmentDTO departmentDto);
    DepartmentDTO getDepartmentById(Long id);
    List<DepartmentDTO> getAllDepartments();
    DepartmentDTO updateDepartment(Long id, DepartmentDTO departmentDto);
    void deleteDepartment(Long id);
}

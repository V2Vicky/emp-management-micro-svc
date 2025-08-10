package com.vvv.employee.service;

import com.vvv.employee.dto.EmployeeDTO;
import com.vvv.employee.dto.ResponseDTO;

import java.util.List;


public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employeeDto);
    ResponseDTO getEmployeeById(Long id);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDto);
    void deleteEmployee(Long id);
}

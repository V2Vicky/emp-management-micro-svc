package com.vvv.employee.service;

import com.vvv.employee.dto.EmployeeDTO;
import com.vvv.employee.mapper.EmployeeMapper;
import com.vvv.employee.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeMapper mapper;
    private EmployeeRepository repository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDto) {

        return null;
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        return null;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return List.of();
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDto) {
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {

    }
}

package com.vvv.employee.service;

import com.vvv.employee.dto.DepartmentDTO;
import com.vvv.employee.dto.EmployeeDTO;
import com.vvv.employee.dto.ResponseDTO;
import com.vvv.employee.entity.Employee;
import com.vvv.employee.exception.ResourceNotFoundException;
import com.vvv.employee.mapper.EmployeeMapper;
import com.vvv.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;
    private final RestTemplate restTemplate;
    private final WebClient webClient;
    private final APIClient apiClient;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO dto) {
        Employee employee = mapper.toEntity(dto);
        Employee save = repository.save(employee);
        return mapper.toDto(save);
    }

    @Override
    public ResponseDTO getEmployeeById(Long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        EmployeeDTO employeeDTO = mapper.toDto(employee);

//        DepartmentDTO departmentDTO = restTemplate.getForObject(
//                "http://localhost:8181/api/departments/department-code/" + employeeDTO.getDepartmentCode(),
//                DepartmentDTO.class);

//        DepartmentDTO departmentDTO = webClient.get()
//                .uri("http://localhost:8181/api/departments/department-code/" + employeeDTO.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDTO.class)
//                .block();

        DepartmentDTO departmentDTO = apiClient.getByDepartmentCode(employee.getDepartmentCode());

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setEmployee(employeeDTO);
        responseDTO.setDepartment(departmentDTO);

        return responseDTO;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {

           List<EmployeeDTO> employeeDTOS = repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
        return employeeDTOS;
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO dto) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        return mapper.toDto(repository.save(employee));
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        repository.delete(employee);
    }
}

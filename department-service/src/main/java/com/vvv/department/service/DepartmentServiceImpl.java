package com.vvv.department.service;

import com.vvv.department.dto.DepartmentDTO;
import com.vvv.department.entity.Department;
import com.vvv.department.exception.ResourceNotFoundException;
import com.vvv.department.mapper.DepartmentMapper;
import com.vvv.department.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepository repository;
    private final DepartmentMapper mapper;

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO dto) {
        Department department = mapper.toEntity(dto);
        return mapper.toDto(repository.save(department));
    }

    @Override
    public DepartmentDTO getDepartmentById(Long id) {
        Department department = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        return mapper.toDto(department);
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String deptCode) {
        Department department = repository.findByDepartmentCode(deptCode);
        return mapper.toDto(department);
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO updateDepartment(Long id, DepartmentDTO dto) {
        Department department = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        department.setDepartmentName(dto.getDepartmentName());
        department.setDepartmentCode(dto.getDepartmentCode());
        department.setLocation(dto.getLocation());
        return mapper.toDto(repository.save(department));
    }

    @Override
    public void deleteDepartment(Long id) {
        Department department = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        repository.delete(department);
    }


}

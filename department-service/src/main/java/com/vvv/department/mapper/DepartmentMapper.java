package com.vvv.department.mapper;

import com.vvv.department.dto.DepartmentDTO;
import com.vvv.department.entity.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentDTO toDto(Department department);
    Department toEntity(DepartmentDTO departmentDto);
}

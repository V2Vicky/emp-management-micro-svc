package com.vvv.employee.mapper;

import com.vvv.employee.dto.EmployeeDTO;
import com.vvv.employee.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee toEntity(EmployeeDTO dto);

    EmployeeDTO toDto(Employee employee);

}

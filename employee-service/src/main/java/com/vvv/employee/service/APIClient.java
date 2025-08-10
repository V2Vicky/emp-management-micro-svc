package com.vvv.employee.service;

import com.vvv.employee.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {

    @GetMapping("/api/departments/department-code/{departmentCode}")
    DepartmentDTO getByDepartmentCode(@PathVariable String departmentCode);
}

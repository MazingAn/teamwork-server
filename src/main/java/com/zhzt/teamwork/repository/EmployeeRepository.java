package com.zhzt.teamwork.repository;

import com.zhzt.teamwork.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
    Employee findEmployeeById(Long id);
}

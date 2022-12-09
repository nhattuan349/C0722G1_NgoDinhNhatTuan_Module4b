package com.md4_casestudy_furame.service.employee;

import com.md4_casestudy_furame.model.employee.Employee;
import com.md4_casestudy_furame.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IEmployeeService extends IGeneralService<Employee> {

    Page<Employee> findByName(Pageable pageable, String name, String division,String educationDegree,String position);

    Page<Employee> findAll(Pageable pageable);

}

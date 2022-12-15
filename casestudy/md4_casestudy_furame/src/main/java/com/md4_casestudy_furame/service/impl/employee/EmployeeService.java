package com.md4_casestudy_furame.service.impl.employee;

import com.md4_casestudy_furame.model.employee.Employee;
import com.md4_casestudy_furame.model.user_role.User;
import com.md4_casestudy_furame.repository.Employee.IEmployeeRepository;
import com.md4_casestudy_furame.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
//        employee.setUser(new User(employee.getEmail(),"123"));
        employeeRepository.save(employee);
    }

    @Override
    public void remove(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findByName(Pageable pageable, String name, String division, String educationDegree, String position) {
        return employeeRepository.findByName(pageable, name, division, educationDegree, position);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }
}

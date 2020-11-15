package com.sda.carrentalservice.service;

import com.sda.carrentalservice.dto.EmployeeDTO;
import com.sda.carrentalservice.entity.Employee;
import com.sda.carrentalservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
//        employee.setFirstName();
//        employee.setLastName();
        employeeRepository.save(employee);
    }

//    public List<Employee> getAllEmployees() {
//
//    }
}

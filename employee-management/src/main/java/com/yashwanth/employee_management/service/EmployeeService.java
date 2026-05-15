package com.yashwanth.employee_management.service;


import com.yashwanth.employee_management.model.Employee;
import com.yashwanth.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(long id){
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(("Employee not found for this id : " + id)));
    }

    public void deleteEmployee(long id){
        employeeRepository.deleteById(id);
    }
}

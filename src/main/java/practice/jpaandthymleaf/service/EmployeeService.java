package practice.jpaandthymleaf.service;

import practice.jpaandthymleaf.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void save(Employee employee);
    List<Employee> findByAll();
    Employee deleteById(int id);
    void updateById(int id);
    Employee findById(int id);
}

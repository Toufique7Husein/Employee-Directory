package practice.jpaandthymleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.jpaandthymleaf.dao.EmployeeRepository;
import practice.jpaandthymleaf.entity.Employee;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    @Autowired
    EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public void save(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findByAll() {
        return this.employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee deleteById(int id) {
        this.employeeRepository.deleteById(id);
        return null;
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        return emp.get();
    }
    @Override
    public void updateById(int id) {
        this.employeeRepository.save(this.findById(id));
    }
}

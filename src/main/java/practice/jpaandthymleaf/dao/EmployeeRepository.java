package practice.jpaandthymleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.jpaandthymleaf.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //sort by lastName
    public List<Employee> findAllByOrderByLastNameAsc();
}

package com.kp.emp_add.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kp.emp_add.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//	List<Employee> findByEmployeeID(Integer id);

	Employee findByFirstNameAndEmployeeID(String name, int id);

}

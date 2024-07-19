package com.kp.emp_add.service;

import java.util.List;

import com.kp.emp_add.model.Employee;

public interface IEmployeeService {
	public List<Employee> getAllEmployees();

	// fetching employee by id
	public Employee getEmployee(int id);

	// inserting employee
	public void addEmployee(Employee e);

	// updating employee by id
	public void updateEmployee(Employee emp, int id);

	// deleting all employees
	public void deleteAllEmployees();

	// deleting employee by id
	public void deleteEmployeeByID(int id);

	// patching/updating employee by id
	public void patchEmployee(Employee emp, int id);

//	public List<Employee> findByEmployeeId(Integer id);

	// fetching employee by id and name
	public Employee getByNameAndId(String name, int id);
	
	// fetching employee by select list of id 
	
	public List<Employee> getSelectedEmpList(List<Integer> allParam);

}

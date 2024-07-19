package com.kp.emp_add.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kp.emp_add.model.Employee;
import com.kp.emp_add.repository.EmployeeRepository;

// employee service class
@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	// fetching all employees
	public List<Employee> getAllEmployees() {
		List<Employee> emps = (List<Employee>) employeeRepository.findAll();
		return emps;
	}

	// fetching employee by id
	public Employee getEmployee(int id) {
		return employeeRepository.findById(id).get();
	}

	// inserting employee
	public void addEmployee(Employee e) {
		employeeRepository.save(e);
	}

	// updating employee by id
	public void updateEmployee(Employee emp, int id) {
		if (id == emp.getEmployeeID()) {
			employeeRepository.save(emp);
		}
	}

	// deleting all employees
	public void deleteAllEmployees() {
		employeeRepository.deleteAll();
	}

	// deleting employee by id
	public void deleteEmployeeByID(int id) {
		employeeRepository.deleteById(id);
	}

	// patching/updating employee by id
	public void patchEmployee(Employee emp, int id) {
		if (id == emp.getEmployeeID()) {
			employeeRepository.save(emp);
		}
	}

	@Override
	public Employee getByNameAndId(String name, int id) {

		return employeeRepository.findByFirstNameAndEmployeeID(name, id);
	}

	@Override
	public List<Employee> getSelectedEmpList(List<Integer> allParam) {
		List<Employee> employeeList = employeeRepository.findAll();

		List<Employee> employees = new ArrayList<>();

		for (Employee emp : employeeList) {
			if (allParam.contains(emp.getEmployeeID())) {
				employees.add(emp);

			}
		}
		

		return employees;
	}

	public List<Employee> getEmployeeById(Integer empId) {
		  Employee emp = employeeRepository.findById(empId).get();
		  
		  List<Employee> employees= new ArrayList<>();
		 
		  if (empId == emp.getEmployeeID()) {
				employees.add(emp);
			}
			
	
		
		return employees;
	}


}

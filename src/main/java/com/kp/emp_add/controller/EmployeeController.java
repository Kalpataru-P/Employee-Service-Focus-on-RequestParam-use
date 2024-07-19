package com.kp.emp_add.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kp.emp_add.model.Employee;
import com.kp.emp_add.service.EmployeeService;

@RestController
public class EmployeeController {

	static final Logger logger = LogManager.getLogger(EmployeeController.class.getName());

	@Autowired
	private EmployeeService employeeService;

	// displaying list of all employees

	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployees();
	}

	// displaying employee by id

	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable Integer id) {

		return employeeService.getEmployee(id);

	}
//	----------------------------------------------RequestParam use Start-----------------------------------------

//	For Display single query parameter
	@GetMapping("/employees/filter")
	public Employee getEmployeeBySingleId(@RequestParam("id") Integer empId) {

		return employeeService.getEmployee(empId);
	}
	
//	For Display optional query parameter
	@GetMapping("/employees/filter/optional")
	public List<Employee> getEmployeeByOptionalId(@RequestParam(value = "id", required = false) Integer empId) {
		
		if(empId!= null) {
			return employeeService.getEmployeeById(empId);
		}else {
			return employeeService.getAllEmployees();
		}

	}

	@GetMapping("/employees/name&id")
	public Employee getEmployeeByFirstNameAndID(@RequestParam String name,@RequestParam Integer id) {

		return employeeService.getByNameAndId(name, id);
	}
	
//	If name is required = false may or may not Present

	@GetMapping("/employees/id&name-false")
	public Employee getEmployeeByOptionalFirstNameAndID(@RequestParam(required = false, defaultValue = "rajj") String name, @RequestParam Integer id) {
		if(name != null && name.length()>0) {
			return employeeService.getByNameAndId(name, id);	
		}else {
			return employeeService.getEmployee(id);
		}
		
	}
//	------------------------------------OR-----------------------------------------
//	If name is Optional may or may not Present
	@GetMapping("/employees/id&optional-name")
	public Employee getEmployeeByOptionalNameAndID(@RequestParam Optional<String> name, @RequestParam Integer id) {
		if(name.isPresent()) {
			return employeeService.getByNameAndId(name.get(), id);	
		}else {
			return employeeService.getEmployee(id);
		}
		
	}

//	For Display Multiple query parameter
	@GetMapping("/employees/filter/ids")
	public List<Employee> getEmployeesByMultipleId(@RequestParam("id") List<Integer> allParam) {

		return (employeeService.getSelectedEmpList(allParam));
	}

//	----------------------------------------------RequestParam use End-----------------------------------------
	// inserting employee
	@PostMapping("/employees")
	public void addEmployees(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}

	// updating employee by id
	@PutMapping("/employees/{id}")
	public void updateEmployee(@RequestBody Employee e, @PathVariable int id) {
		employeeService.updateEmployee(e, id);
	}

	// deleting all employees
	@DeleteMapping("/employees")
	public void deleteAllEmployees() {
		employeeService.deleteAllEmployees();
	}

	// deleting employee by id
	@DeleteMapping("employees/{id}")
	public void deleteEmployeeByID(@RequestBody Employee e, @PathVariable int id) {
		employeeService.deleteEmployeeByID(id);
	}

	// updating/ patching employee by id
	@PatchMapping("employees/{id}")
	public void patchEmployeeByID(@RequestBody Employee e, @PathVariable int id) {
		employeeService.patchEmployee(e, id);
	}

}

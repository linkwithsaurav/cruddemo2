package com.saurav.cruddemo2.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saurav.cruddemo2.entity.Employee;
import com.saurav.cruddemo2.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
 	
	@GetMapping("/employee")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employee/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee employee = employeeService.findById(employeeId);
		
		if(employee == null) {
			throw new RuntimeException("Employee is not found"+employeeId);
		}
		 
		return employee;
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		employee.setId(0);
		
		employeeService.save(employee);
		
		return employee;
	}
	
	
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee temp = employeeService.findById(employeeId);
		
		if(temp == null) {
			throw new RuntimeException("Employee id not found"+employeeId);
		}
		
		employeeService.deleteById(employeeId);
		
		return "deleted employee id "+employeeId;
		
	}
	

}

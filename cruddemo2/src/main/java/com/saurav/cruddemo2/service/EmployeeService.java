package com.saurav.cruddemo2.service;

import java.util.List;

import com.saurav.cruddemo2.entity.Employee;

public interface EmployeeService {

	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);
}


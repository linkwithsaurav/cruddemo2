package com.saurav.cruddemo2.dao;

import java.util.List;

import com.saurav.cruddemo2.entity.Employee;

public interface EmployeeDao {

	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);
}

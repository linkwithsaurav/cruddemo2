package com.saurav.cruddemo2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saurav.cruddemo2.dao.EmployeeDao;
import com.saurav.cruddemo2.entity.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {

	public EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeServiceImp(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return employeeDao.findById(id);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		
		employeeDao.save(employee);

	}

	@Override
	@Transactional
	public void deleteById(int id) {
		employeeDao.deleteById(id);
		// TODO Auto-generated method stub

	}

}

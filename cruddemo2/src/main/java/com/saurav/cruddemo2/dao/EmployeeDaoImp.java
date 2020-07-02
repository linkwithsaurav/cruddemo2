package com.saurav.cruddemo2.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.saurav.cruddemo2.entity.Employee;

@Repository
public class EmployeeDaoImp implements EmployeeDao {
	
	private EntityManager entityManager;	
	
	@Autowired
	public EmployeeDaoImp(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}



	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		
		Session unwrap = entityManager.unwrap(Session.class);
		
		Query<Employee> query = unwrap.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = query.getResultList();
		
		return employees;
	}



	@Override
	@Transactional
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		
		Employee employee = session.get(Employee.class, id);
		
		return employee;
	}



	@Override
	@Transactional
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		Session unwrap = entityManager.unwrap(Session.class);
		
		unwrap.saveOrUpdate(employee);
		
	}



	@Override
	@Transactional
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Session unwrap = entityManager.unwrap(Session.class);
		
		Query query = unwrap.createQuery("delete from Employee where id = employeeId");
		
		query.setParameter("employeeId", id);
		
		query.executeUpdate();
	}

}

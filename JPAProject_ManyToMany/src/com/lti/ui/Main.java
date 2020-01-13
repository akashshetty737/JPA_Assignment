package com.lti.ui;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Department;
import com.lti.model.Employee;

public class Main {
	public static void main(String[] args) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
			EntityManager entityManager = factory.createEntityManager();
			entityManager.getTransaction().begin();
			
			
			Department department = new Department(10, "Development");
			Department department2 = new Department(20, "HR");
			
			Employee employee = new Employee(100, "Rohan",7500);
			Employee employee2 = new Employee(101, "Sushmita", 7000);
			Employee employee3 = new Employee(102,"KrishnaSai",9000);
			Employee employee4 = new Employee(103,"Lavanya",10000);
			
			Set<Employee> emps = new HashSet<Employee>();
			Set<Employee> emps2 = new HashSet<Employee>();
			
			employee.setDepartment(department);
			employee2.setDepartment(department);
			employee3.setDepartment(department2);
			employee4.setDepartment(department2);
			
			department.setEmployees(emps);
			department2.setEmployees(emps2);
			
			emps.add(employee);
			emps.add(employee2);
			emps2.add(employee3);
			emps2.add(employee4);
			
			
			entityManager.persist(department);
			entityManager.persist(department2);
			
			entityManager.getTransaction().commit();
			entityManager.close();
			factory.close();
			
			
			
			
			
	}

}

package com.lti.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
			EntityManager entityManager = factory.createEntityManager();
			entityManager.getTransaction().begin();
			
			
			
			entityManager.getTransaction().commit();
			entityManager.close();
			factory.close();
			
			
			
			
			
	}

}

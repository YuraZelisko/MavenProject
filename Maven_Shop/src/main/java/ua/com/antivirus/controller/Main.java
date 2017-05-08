package ua.com.antivirus.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {

		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("primary");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		
		
		
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
		
	
//		EntityManager manager = factory.createEntityManager();
//		
//		manager.getTransaction().begin();
//		
//		manager.getTransaction().commit();
//		
//		manager.close();
//		factory.close();
//		
		
	}
}
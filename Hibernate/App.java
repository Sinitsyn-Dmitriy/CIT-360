package org.studyeasy.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.studyeasy.hibernate.entity.Users;

public class App {
	
	public static void addNew()
	{
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Users.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
		
		Users user = new Users("dmi", "12345d", "Dmitriy", "Sinitsyn");  

		
		session.beginTransaction();
		
		session.save(user);  
		user = session.get(Users.class, 0);
		
		
		
		session.flush();
		
		session.getTransaction().commit();
		System.out.println("Row added!");
		
		System.out.println(user);			
		
		
		} finally {
		
		session.close();
		factory.close();
		}

		
	}
	public static void edit()
	{
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Users.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
		
		Users user = new Users();   
		
		session.beginTransaction();
		
		
		user = session.get(Users.class, 10);
		
		user.setUsername("admin@admin.com");
		
		session.flush();
		
		session.getTransaction().commit();
		System.out.println("Row edited!");
		
		System.out.println(user);			
		
		
		} finally {
		
		session.close();
		factory.close();
		}

		
	}
	public static void delete()
	{
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Users.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
		
		
		Users user = new Users();   
		
		session.beginTransaction();
		
		
		
		user = session.get(Users.class, 9);
		
		session.delete(user);
		
		
		
		session.flush();
		
		session.getTransaction().commit();
		System.out.println("Row deleted!");
		
		System.out.println(user);			
		
		
		} finally {
		
		session.close();
		factory.close();
		}

		
	}
	
	
	
	public static void main(String[] args)
	{
	
		edit();
		addNew();
		delete();
	}
}

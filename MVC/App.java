package org.studyeasy.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.studyeasy.hibernate.entity.Users;

public class App {
	
	public static void addNew(String username, String password, String firstname, String lastname)
	{
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Users.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
		
		Users user = new Users(username, password, firstname, lastname);  

		
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
		
		
		View v = new View();
		String username = v.username();
		String password = v.password();
		String firstname = v.firstname();
		String lastname = v.lastname();
	
		//delete();
		//edit();
		addNew(username, password, firstname, lastname);
		
		v.end(username, password, firstname, lastname);
		
	}
}

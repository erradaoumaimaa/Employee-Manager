package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import models.Employee;

public class Main {

    public static void main(String[] args) {
    	
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        
        Employee empl = new Employee();
        empl.setName("oumaima");
        empl.setEmail("email@gmail.com");
        empl.setPhone("0694253502");
        empl.setDepartment("info");
        empl.setPosition("consultant");
        
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        session.persist(empl);
        
        transaction.commit();
        session.close(); 
        sessionFactory.close(); 
        
    }
}

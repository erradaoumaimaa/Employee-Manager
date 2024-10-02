package DAO.implementations;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import DAO.interfaces.EmployeeDAO;
import models.Employee;
import utils.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	private SessionFactory sessionFactory;
	public EmployeeDAOImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
	@Override
	public Optional<Employee> findById(int id) {
		Transaction transaction = null;
		Employee employee = null;
		
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			employee = session.get(Employee.class, id); 
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback(); 
			}
			e.printStackTrace(); 
		}
		
		return Optional.ofNullable(employee); 
	}
	
	
    @Override
    public void addEmployee(Employee employee) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); 
        }
    }
    
	@Override
	public void removeEmployee(int id) {
		Transaction transaction = null;
		try(Session session = sessionFactory.openSession()){
			transaction = session.beginTransaction();
		Optional<Employee> findEmp = findById(id);
		if(findEmp.isPresent()) {
			Employee emp = findEmp.get();
			session.remove(emp);
			transaction.commit();
		} else {
            System.out.println("Employee not found id: " + id);
        }	
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void updateEmployee(Employee employee) {
	    Transaction transaction = null;
	    try (Session session = sessionFactory.openSession()) {
	        transaction = session.beginTransaction();
	        Optional<Employee> findEmp = findById(employee.getId());
	        if (findEmp.isPresent()) {
	            session.update(employee);
	            transaction.commit();
	        } else {
	            System.out.println("Employee not found  id: " + employee.getId());
	        }
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace(); 
	    }
	}




	@Override
	public List<Employee> getAllEmployees() {
	    Transaction transaction = null;
	    List<Employee> employees = null; 
	    
	    try (Session session = sessionFactory.openSession()) {
	        transaction = session.beginTransaction();
	        employees = session.createQuery("FROM Employee", Employee.class).list(); 
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback(); 
	        }
	        e.printStackTrace(); 
	    }
	    
	    return employees; 
	}	
}

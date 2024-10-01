package DAO.implementations;

import java.util.List;

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
            e.printStackTrace(); // Log the error
        }
    }
	@Override
	public void removeEmployee(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployee(Employee employee) {
        
    }


	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> filterEmployees(String search) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

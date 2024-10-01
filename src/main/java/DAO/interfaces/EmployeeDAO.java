package DAO.interfaces;

import java.util.List;

import models.Employee;

public interface EmployeeDAO {
	void addEmployee(Employee employee);
	void removeEmployee(int id);
	void updateEmployee(Employee employee);
	List<Employee> getAllEmployees();
	List<Employee> filterEmployees(String search);
}

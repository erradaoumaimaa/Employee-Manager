package services.interfaces;

import java.util.List;
import java.util.Optional;

import models.Employee;

public interface EmployeeService {

	 void addEmployee(Employee employee);
	    
	    void removeEmployee(int id);
	    
	    void updateEmployee(Employee employee);
	    
	    List<Employee> getAllEmployees();
	    
	    List<Employee> filterEmployees(String position,String department);
	    
	    Optional<Employee> findById(int id);

}

package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.implementations.EmployeeDAOImpl;
import models.Employee;
import services.implementations.EmployeeServiceImpl;
import services.interfaces.EmployeeService;
import javax.servlet.annotation.WebServlet;


@WebServlet("/employees")
public class EmployeeController extends HttpServlet {
	private EmployeeService employeeService;
	
	public void init(ServletConfig config) throws ServletException {
        super.init(config);
        
        this.employeeService = new EmployeeServiceImpl(new EmployeeDAOImpl());
        
    }
	
	
	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException{
			
		List<Employee> employees = employeeService.getAllEmployees();
		
		request.setAttribute("employees", employees);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request ,HttpServletResponse response)throws ServletException, IOException{
		
		
    }

}

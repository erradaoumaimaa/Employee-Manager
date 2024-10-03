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

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.employeeService = new EmployeeServiceImpl(new EmployeeDAOImpl());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if (action == null || action.equals("list")) {
            listEmployees(request, response);
        } else if (action.equals("delete")) {
            deleteEmployee(request, response);
        }
    }

    private void listEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = employeeService.getAllEmployees();
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.removeEmployee(id);
        response.sendRedirect(request.getContextPath() + "/employees?action=list");
    }
    
    
    

}


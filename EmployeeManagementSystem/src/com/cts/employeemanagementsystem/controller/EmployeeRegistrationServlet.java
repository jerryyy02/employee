package com.cts.employeemanagementsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.employeemanagementsystem.service.EmployeeService;
import com.cts.employeemanagementsystem.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeRegistrationServlet
 */
public class EmployeeRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String password = request.getParameter("password");
		String cpassword = request.getParameter("cpassword");
		String salary = request.getParameter("salary");
		System.out.println(userId+" "+fName+" "+lName+" "+password+" "+salary);
		RequestDispatcher requestDispatcher= null;
		EmployeeService employee = EmployeeServiceImpl.getInstance();
		if(employee.passwordCheck(password, cpassword)){
		if(employee.setUserData(userId, fName, lName, password, salary)){
			requestDispatcher=request.getRequestDispatcher("inserted.html");
			requestDispatcher.forward(request, response);
		}
		else{
			requestDispatcher=request.getRequestDispatcher("notinserted.html");
			requestDispatcher.forward(request, response);
		}
		}
		else{
			System.out.println("pass not match");
		}
		
	}

}

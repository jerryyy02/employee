package com.cts.employeemanagementsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.employeemanagementsystem.service.LoginService;
import com.cts.employeemanagementsystem.service.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LoginService loginService = LoginServiceImpl.getInstance();
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		RequestDispatcher requestDispatcher= null;
		if(loginService.authenticate(userId, password)){
			//response.sendRedirect("admin.html");
			//requestDispatcher=request.getRequestDispatcher("admin.html");
			//requestDispatcher.forward(request, response);
			//requestDispatcher.include(request, response);
			int userStatus = loginService.getUserStatus(userId);
			String authorization = loginService.authorization(userId);
			/*if("A".equals(authorization))
			{
				if(userStatus==0 || userStatus==1)
				{
					requestDispatcher=request.getRequestDispatcher("admin.html");
					requestDispatcher.forward(request, response);}
				else
				{
					requestDispatcher = request.getRequestDispatcher("deactivated_user.html");
					requestDispatcher.forward(request, response);}
				}

			
		if("U".equals(authorization))
		{
			if(userStatus==0 || userStatus==1)
			{
				requestDispatcher = request.getRequestDispatcher("user.html");
				requestDispatcher.forward(request, response);
			}
			else
			{
				requestDispatcher = request.getRequestDispatcher("deactivated_user.html");
				requestDispatcher.forward(request, response);}
			

		}if("V".equals(authorization))
		{
			if(userStatus==0 || userStatus==1)
			{
				requestDispatcher= request.getRequestDispatcher("vendor.html");
				requestDispatcher.forward(request, response);}
			else
			{
				requestDispatcher = request.getRequestDispatcher("deactivated_user.html");
				requestDispatcher.forward(request, response);}
			}

		}*/
			if(userStatus==0){
				if("a".equals(authorization))
				{
						requestDispatcher=request.getRequestDispatcher("admin.html");
						requestDispatcher.forward(request, response);
				}
				if("u".equals(authorization))
				{
						requestDispatcher=request.getRequestDispatcher("user.html");
						requestDispatcher.forward(request, response);
				}
				if("v".equals(authorization))
				{
						requestDispatcher=request.getRequestDispatcher("VendorHome.html");
						requestDispatcher.forward(request, response);
				}
			}
			if(userStatus==1){
				requestDispatcher = request.getRequestDispatcher("loggedIn.html");
				requestDispatcher.forward(request, response);
			}
			if(userStatus==2){
				requestDispatcher = request.getRequestDispatcher("deactivated_user.html");
				requestDispatcher.forward(request, response);
			}
		}
		
			else{
				System.out.println("invalid");
				response.sendRedirect("login.html");
			}
		
		
	}
}

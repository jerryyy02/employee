package com.cts.employeemanagementsystem.service;

import com.cts.employeemanagementsystem.dao.EmployeeDAO;
import com.cts.employeemanagementsystem.dao.EmployeeDAOImpl;

public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDAO dao = EmployeeDAOImpl.getInstance();
	
	private static EmployeeServiceImpl employeeServiceImpl;
	public static EmployeeServiceImpl getInstance() {
		if(employeeServiceImpl==null){
			employeeServiceImpl = new EmployeeServiceImpl();
			return employeeServiceImpl;
		}
		else {
			return employeeServiceImpl;
		}
	}
	
	private EmployeeServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public boolean setUserData(String userId, String fName, String lName, String password, String salary) {
		// TODO Auto-generated method stub
		return dao.setUserData(userId,fName,lName,password,salary);
	}

	public boolean passwordCheck(String password, String cpassword) {
		// TODO Auto-generated method stub
		return dao.passwordCheck(password, cpassword);
	}

}

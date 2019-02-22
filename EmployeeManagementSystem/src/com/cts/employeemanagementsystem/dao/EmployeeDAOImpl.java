package com.cts.employeemanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cts.employeemanagementsystem.util.DBUtils;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	private static EmployeeDAOImpl employeeDAOImpl;
	
	public static EmployeeDAOImpl getInstance() {
		if(employeeDAOImpl==null){
			employeeDAOImpl=new EmployeeDAOImpl();
			return employeeDAOImpl;
		}
		else {
			return employeeDAOImpl;
		}
	}
	
	private EmployeeDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean passwordCheck(String password, String cpassword){
	      if(password.equals(cpassword)){
	    	  return true;
	    	}
	      else{
	    	  return false;
	      }
	}

	public boolean setUserData(String userId, String fName, String lName, String password, String salary) {
		// TODO Auto-generated method stub
		String query = "Insert into employee values(?,?,?,?,?)";
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DBUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, fName);
			preparedStatement.setString(3, lName);
			preparedStatement.setString(4, password);
			preparedStatement.setString(5, salary);
			resultSet = preparedStatement.executeQuery();
			if(resultSet!=null)
				return true;
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	return false;
	}

}

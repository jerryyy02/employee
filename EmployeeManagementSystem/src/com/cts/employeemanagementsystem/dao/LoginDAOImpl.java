package com.cts.employeemanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cts.employeemanagementsystem.util.DBUtils;

public class LoginDAOImpl implements LoginDAO
{
	private static LoginDAOImpl loginDAOImpl;
	public static LoginDAOImpl getInstance() {
		if(loginDAOImpl==null){
			loginDAOImpl=new LoginDAOImpl();
			return loginDAOImpl;
		}
		else {
			return loginDAOImpl;
		}
		
	}
private LoginDAOImpl() {
	// TODO Auto-generated constructor stub
	
}
	public int getUserStatus(String id) {
		// TODO Auto-generated method stub
		String query = "Select status from login where userId=?";
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DBUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return resultSet.getInt("status");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public String getUserType(String id) {
		// TODO Auto-generated method stub
		String query = "Select usertype from login where userId=?";
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DBUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return resultSet.getString("usertype");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean authenticate(String userId, String password) {
		// TODO Auto-generated method stub
		String query = "select * from login where userId=? and password=?";
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DBUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public String authorization(String userId) {
		// TODO Auto-generated method stub
		return getUserType(userId);
	}

}

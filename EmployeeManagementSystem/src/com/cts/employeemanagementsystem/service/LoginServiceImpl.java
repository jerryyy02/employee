package com.cts.employeemanagementsystem.service;

import com.cts.employeemanagementsystem.dao.LoginDAO;
import com.cts.employeemanagementsystem.dao.LoginDAOImpl;

public class LoginServiceImpl implements LoginService {
	
	private static LoginServiceImpl loginServiceImpl;
	private LoginDAO dao = LoginDAOImpl.getInstance();
	
	public static LoginServiceImpl getInstance() {
		if(loginServiceImpl==null){
			loginServiceImpl =new LoginServiceImpl();
			return loginServiceImpl;
		}
		else {
			return loginServiceImpl;
		}
		
	}
	
	private LoginServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public int getUserStatus(String id) {
		// TODO Auto-generated method stub
		return dao.getUserStatus(id);
	}

	public String getUserType(String id) {
		// TODO Auto-generated method stub
		return dao.getUserType(id);
	}

	public boolean authenticate(String userId, String password) {
		// TODO Auto-generated method stub
		return dao.authenticate(userId, password);
	}

	public String authorization(String id) {
		// TODO Auto-generated method stub
		return dao.authorization(id);
	}

}

package com.cts.employeemanagementsystem.dao;

public interface EmployeeDAO {
	public boolean setUserData(String userId, String fName, String lName, String password, String salary);
	public boolean passwordCheck(String password, String cpassword);
}

package com.cts.employeemanagementsystem.service;

public interface EmployeeService {
	public boolean setUserData(String userId, String fName, String lName, String password, String salary);
	public boolean passwordCheck(String password, String cpassword);
}

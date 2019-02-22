package com.cts.employeemanagementsystem.bean;

public class Employee {
private String empId;
private String firstName;
private String lastName;
private float salary;

private static Employee employee;

public static Employee getInstance(){
	if(employee == null){
	employee = new Employee();
	return employee;
	}
	else{
		return employee;
	}
}

public String getEmpId() {
	return empId;
}
public void setEmpId(String empId) {
	this.empId = empId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public float getSalary() {
	return salary;
}
public void setSalary(float salary) {
	this.salary = salary;
}

public Employee() {
	// TODO Auto-generated constructor stub
}

public Employee(String empId, String firstName, String lastName, float salary) {
	super();
	this.empId = empId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.salary = salary;
}


}

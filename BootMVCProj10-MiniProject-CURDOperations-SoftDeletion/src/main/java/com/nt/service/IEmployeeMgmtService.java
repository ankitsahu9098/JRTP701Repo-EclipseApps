package com.nt.service;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {
	
	public Iterable<Employee> getAllEmployee();
	public String registerEmployee(Employee emp) ;
	public Employee fetchEmployeeById(int id);
	public String updateEmployee(Employee emp);
	public String deleteEmployeeById(int id);

}

package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repo.IEmployeeRepositary;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepositary empRepo;

	@Override
	public Iterable<Employee> getAllEmployee() {

		return empRepo.findAll();

	}

	@Override
	public String registerEmployee(Employee emp) {
		int id = empRepo.save(emp).getEmpno();
		return "employee is saved with the id value :: " + id;
	}

	@Override
	public Employee fetchEmployeeById(int id) {

		return empRepo.findById(id).orElseThrow(()->new IllegalArgumentException());
	}
	
	@Override
	public String updateEmployee(Employee emp) {
		empRepo.save(emp);
		return "Employee No. "+emp.getEmpno()+" employee details is updated";
	}
		@Override
		public String deleteEmployeeById(int id) {
			empRepo.deleteById(id);
			return "Employee no. "+id+" Employee Details is deleted";
		}
}

package com.nt.repo;

import org.springframework.data.repository.CrudRepository;

import com.nt.model.Employee;

public interface IEmployeeRepositary extends CrudRepository<Employee, Integer> {

}

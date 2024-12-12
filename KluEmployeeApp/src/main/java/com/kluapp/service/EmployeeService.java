package com.kluapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kluapp.Exceptionpack.ResourceNotFoundException;
import com.kluapp.model.Employee;
import com.kluapp.repo.EmployeesRepo;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {

	@Autowired
	private EmployeesRepo employeesRepo;
	
	public List<Employee> getAllEmployees(){
		return employeesRepo.findAll();
	}
	public void deleteEmpById(Long eid) {
	    employeesRepo.deleteById(eid);
	  }
	@Transactional 
	public Employee updateEmployee(Long id, Employee employeeDetails) 
	{ 
		Optional<Employee> employeeOptional = employeesRepo.findById(id); 
		if (employeeOptional.isPresent()) 
		{ 
			Employee employee = employeeOptional.get(); 
			employee.setEname(employeeDetails.getEname()); 
			employee.setEsal(employeeDetails.getEsal()); 
			employee.setEimage(employeeDetails.getEimage()); 
			employee.setEdesig(employeeDetails.getEdesig()); 
			return employeesRepo.save(employee); 
		} 
		else { 
			throw new ResourceNotFoundException("Employee not found with id " + id); } }
}

package com.kluapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kluapp.model.Employee;
import com.kluapp.service.EmployeeService;

@RestController
@CrossOrigin("*")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("allemployees")
	public List<Employee> displayAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	@DeleteMapping("/employees/{id}")
	  public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id){
	    try {
	      employeeService.deleteEmpById(id);
	      return ResponseEntity.ok("Employee with Id" + id +"has been deleted successfully");
	    }
	    catch(Exception e) {
	      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting employee: " + e.getMessage());
	    }
	  }
	
	@PutMapping("/{id}") 
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) { 
			Employee updatedEmployee = employeeService.updateEmployee(id, employeeDetails); 
			return ResponseEntity.ok(updatedEmployee); 
			}
}

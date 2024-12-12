package com.kluapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kluapp.model.Employee;

@Repository
public interface EmployeesRepo extends JpaRepository<Employee,Long>{

}

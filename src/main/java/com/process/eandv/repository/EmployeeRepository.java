package com.process.eandv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.process.eandv.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}

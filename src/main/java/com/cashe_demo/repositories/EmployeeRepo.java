package com.cashe_demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cashe_demo.entities.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}

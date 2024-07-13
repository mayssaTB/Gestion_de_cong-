package com.example.holiplanner.Repositories;

import com.example.holiplanner.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

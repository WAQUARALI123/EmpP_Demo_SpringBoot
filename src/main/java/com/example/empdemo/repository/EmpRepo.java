package com.example.empdemo.repository;

import java.security.Identity;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.empdemo.entity.Employee;

public interface EmpRepo extends JpaRepository<Employee, Long>
{

}

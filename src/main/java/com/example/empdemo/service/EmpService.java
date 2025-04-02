package com.example.empdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.empdemo.dto.EmpDto;
import com.example.empdemo.entity.Employee;
import com.example.empdemo.repository.EmpRepo;

@Service
public class EmpService {
 
	@Autowired
	private EmpRepo empRepo;
	
	
	public Employee getEmp(Long id) {
		
		return empRepo.findById(id).orElse(null);
	}
	

	
	
	
	public List<EmpDto> getAll(){
		
		List<Employee> employees = empRepo.findAll();
		
		List<EmpDto> empDtoList= new ArrayList<>();
		
		for(Employee emp : employees) {
			
			EmpDto dto =new EmpDto();
			
			dto.setName(emp.getName());
			dto.setAge(emp.getAge());
			
			empDtoList.add(dto);
		}
				return empDtoList;
				
	}
	
	
	

	
	
	
	public EmpDto createEmp(EmpDto empDto) {
		
		Employee emp =new Employee();
		
		emp.setName(empDto.getName());
		emp.setAge(empDto.getAge());
		
		Employee empSaved =empRepo.save(emp);
		
		EmpDto dto =new EmpDto();
		
		dto.setName(empSaved.getName());
		dto.setAge(empSaved.getAge());
		
		return dto;
		
		
	}
	
	

	
	
	
	public EmpDto updateEmp( Long id,  EmpDto empDto) {
		
		
		Employee emp= empRepo.findById(id).orElse(null);
		
		emp.setName(empDto.getName());
		emp.setAge(empDto.getAge());
		
		Employee savedEmp= empRepo.save(emp);
		
		
		EmpDto dto= new EmpDto();
		
		dto.setName(savedEmp.getName());
		dto.setAge(savedEmp.getAge());
		
		return dto;
		
	}
	

	
	
	
	public EmpDto deleteE(Long id) {
		
		Employee emp = empRepo.findById(id).orElse(null);
		
		EmpDto dto =new EmpDto();
		
		dto.setName(emp.getName());
		dto.setAge(emp.getAge());
		
		empRepo.deleteById(id);
		
		return dto;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 
 
 
}

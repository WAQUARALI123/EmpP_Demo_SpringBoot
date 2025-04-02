package com.example.empdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.empdemo.dto.EmpDto;
import com.example.empdemo.entity.Employee;
import com.example.empdemo.repository.EmpRepo;
import com.example.empdemo.service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController


public class EmpController {
	
    private static final Logger logger = LoggerFactory.getLogger(EmpController.class);

	
	@Autowired
	private EmpService empService;
	@Autowired
	private EmpRepo empRepo;

	
	
	@GetMapping("/getemp/{id}")
	
	public ResponseEntity<Employee>  getEmp(@PathVariable Long id) {
		
		logger.info("fetching employee with ID :{}", id);
		
		Employee employee = empService.getEmp(id);
		
		if(employee!= null) {
			
		return ResponseEntity.ok(employee);
		}
		else {
			logger.warn("Employee with ID{} not found", id);
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
//	@GetMapping("/getemp/{id}")
//	public ResponseEntity<String> getEmp(@PathVariable Long id) {
//	    logger.info("fetching employee with ID :{}", id);
//
//	    Employee employee = empService.getEmp(id);
//
//	    if (employee != null) {
//	        return ResponseEntity.ok("Employee found: " + employee.getName());
//	    } else {
//	        String errorMessage = "Employee with ID " + id + " not found";
//	        logger.warn(errorMessage);
//	        return ResponseEntity.status(404).body(errorMessage);  // Custom message with 404 status
//	    }
//	}
//
	
	@GetMapping("/getA")
	public ResponseEntity<List<EmpDto>> getAl(){
		
		logger.info("Fetching all employees");
	
		
		List<EmpDto> emp = empService.getAll();
		

		logger.info("Total Employee found: {}", emp.size());	
		return ResponseEntity.ok(emp);
		
	}
	
	
	

	@PostMapping("/create")
	public ResponseEntity<EmpDto> createEmp(@RequestBody EmpDto empDto){
		
		logger.info("Creating new employee: {}", empDto.getName());
		
		EmpDto dto= empService.createEmp(empDto);
		
		logger.info("Employee created successfully: {}", dto.getName());
		
		return ResponseEntity.ok(dto);
	}
	
	
	
	
	
	@PutMapping("/u/{id}")
	public ResponseEntity<EmpDto> updateEmp(@PathVariable Long id , @RequestBody EmpDto empDto){
		
		logger.info("Updating employee with ID: {}", id);
	  EmpDto dto = empService.updateEmp(id, empDto);	
	  
	  logger.info("Employee updated {}: ", dto.getName());
	
	  return ResponseEntity.ok(dto);
	}
	

	
	@DeleteMapping("/dele/{id}")
	public ResponseEntity<EmpDto> deleteEmp(@PathVariable long id){
		
		logger.info("Deleting employee with ID {}:" , id);
		
		EmpDto dto =empService.deleteE(id);
		
		logger.info("Deletion response {} :", dto);
		
		return ResponseEntity.ok(dto);
	}
	
	
	
	
	
}

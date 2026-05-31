package com.example.demo.Service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.demo.Entity.Employee;


public interface EmployeeService {
	
	public ResponseEntity<?> addEmployeeDetails(Employee emp);
	
	public ResponseEntity<?> getAllEmployeeList();
	
	public ResponseEntity<?> getEmployeeeById(Long id);
	
	public ResponseEntity<?> getEmployeeByName(String name);
		
	public ResponseEntity<?> deleteEmployeeeById(Long id);

	public ResponseEntity<?> updateEmployeeBySalary(double salary, Employee entity);

	public ResponseEntity<?> updateEmployee(Long id, Employee employeeEntity);

	
	
	//IMP menthods for understanding
	
	public ResponseEntity<?> findeEmployeeBySalary(double salary);
	
	public ResponseEntity<?> findeEmployeeBySalaryJPQL(double salary);
	
	public ResponseEntity<?> findeEmployeeBySalarySQL(double salary);
	
	public ResponseEntity<?> findBySalaryGreaterThan(double salary);
	
	public Optional<?>  avgSalary();
	
	//Sorting and pagination

	public ResponseEntity<?> findEmployeeBySalaryWithSorting(String name);
	
	public ResponseEntity<?> findEmployeeByNameWithPagination(int pagenumber, int pagesize);


	public ResponseEntity<?> findEmployeeByNameWithPaginationandSorting(int pagenumber, int pagesize, String name);
	
	
	

}

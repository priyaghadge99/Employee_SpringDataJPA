package com.example.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Employee;
import com.example.demo.Service.EmployeeService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	@PostMapping("/add")
	public ResponseEntity<?> addEmployeeDetails(@RequestBody Employee employeeEntity) {
		ResponseEntity<?> employeeDetails = employeeService.addEmployeeDetails(employeeEntity);
		return employeeDetails;
	}
	@GetMapping("/all")
	public ResponseEntity<?>  getAllEmployeeList() {
		ResponseEntity<?> allEmployeeList = employeeService.getAllEmployeeList();
		return allEmployeeList;
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<?>  getEmployeeByName(@PathVariable String name) {
		ResponseEntity<?> employeeByName = employeeService.getEmployeeByName(name);
		return employeeByName;
	}
	
	@GetMapping("/")  //not coorect output
	public ResponseEntity<?> getEmployeeeById(@RequestParam Long id) {
		ResponseEntity<?> employeeeById = employeeService.getEmployeeeById(id);
		return employeeeById;
	}
	
	@PutMapping("/update/{id}")    //update 
	public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody Employee entity) {
		return employeeService.updateEmployee(id,entity);
		
	}
	
	@DeleteMapping("/")
     public ResponseEntity<?> deleteEmployee(@RequestParam Long id){
		return employeeService.deleteEmployeeeById(id);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<?> updateEmployeeBySalary(@RequestParam double Salary, @RequestBody Employee entity)
	{
		return employeeService.updateEmployeeBySalary(Salary, entity);
	}
	
	
	@GetMapping("/getbySalary")
	public ResponseEntity<?> geteEmployeeBySalary(@RequestParam double salary) {
		return employeeService.findeEmployeeBySalary(salary);
	}
	
	
	@GetMapping("/getbySalary/jpql")
	public ResponseEntity<?> geteEmployeeBySalary2(@RequestParam double salary) {
		return employeeService.findeEmployeeBySalaryJPQL(salary);
	}
	
	@GetMapping("/getbySalary/sql")  //not working
	public ResponseEntity<?> geteEmployeeBySalary3(@RequestParam double salary) {
		return employeeService.findeEmployeeBySalarySQL(salary);
	}
	
	
	@GetMapping("/salgreater")
	public ResponseEntity<?> getBySalaryGreaterThan(@RequestParam double salary) {
		return employeeService.findBySalaryGreaterThan(salary);
	}
	
	@GetMapping("/avg")
	public Optional<?> getavgSalary(@RequestParam double salary) {
		return employeeService.avgSalary();
	}
	
	
	@GetMapping("/getbysort")
	public ResponseEntity<?> getEmployeeWithSorting(@RequestParam String name) {
		return employeeService.findEmployeeBySalaryWithSorting(name);
	}
	
	@GetMapping("/getbypagination")
	public ResponseEntity<?> getEmployeeByNameWithPagination(@RequestParam int pageno,@RequestParam int pagesize) {
		return employeeService.findEmployeeByNameWithPagination(pageno, pagesize);
	}
	
	@GetMapping("/getbypaginationandsort")
	public ResponseEntity<?> get(@RequestParam int pageno,@RequestParam int pagesize,@RequestParam String name) {
		return employeeService.findEmployeeByNameWithPaginationandSorting(pageno, pagesize, name);
	}

}

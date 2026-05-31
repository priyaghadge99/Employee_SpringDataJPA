package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Employee;
import com.example.demo.Repository.EmployeeRepository;

@Service
public class EmployeeServiceimpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public ResponseEntity<?> addEmployeeDetails(Employee emp) {

		Employee save = employeeRepository.save(emp);
		return new ResponseEntity<Employee>(save, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<?> getEmployeeeById(Long id) {
		List<Employee> allById = employeeRepository.findAllById(id);
		return new ResponseEntity<List<Employee>>(allById, HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<?> getAllEmployeeList() {
		List<Employee> allEmployee = employeeRepository.findAll();
		return new ResponseEntity<List<Employee>>(allEmployee, HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<?> getEmployeeByName(String name) {
		List<Employee> byName = employeeRepository.findByName(name);
		return new ResponseEntity<List<Employee>>(byName, HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<?> updateEmployee(Long id, Employee employeeEntity) {

		Employee existing = employeeRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Employee with ID " + id + " not found"));

		existing.setDateOfJoining(employeeEntity.getDateOfJoining());
		existing.setEmailId(employeeEntity.getEmailId());
		existing.setName(employeeEntity.getName());
		existing.setSalary(employeeEntity.getSalary());
		existing.setAge(employeeEntity.getAge());

		return new ResponseEntity<>(existing, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteEmployeeeById(Long id) {

		employeeRepository.deleteById(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override // notworking
	public ResponseEntity<?> updateEmployeeBySalary(double salary, Employee entity) {
		// Step 1: Find all employees with the given salary
		List<Employee> emp = employeeRepository.findBySalary(salary);
		// Step 2: Check if any employees found

		if (emp.isEmpty() || emp == null) {
			return new ResponseEntity<>("No Employee found", HttpStatus.NOT_FOUND);
		}

		// Step 3: Update each employee's fields with values from entity
		List<Employee> updatedList = new ArrayList<>();

		for (Employee employeeExisting : updatedList) {

			employeeExisting.setSalary(entity.getSalary());

			updatedList.add(employeeExisting);
		}
		// Step 3: Save all the Employee object
       List<Employee> saveAll = employeeRepository.saveAll(updatedList);
		return new ResponseEntity<>(saveAll, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> findeEmployeeBySalary(double salary) {
		List<Employee> findeEmployeeBySalary = employeeRepository.findEmployeeBySalary(salary);
		return new ResponseEntity<>(findeEmployeeBySalary, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> findeEmployeeBySalaryJPQL(double salary) {
		return new ResponseEntity<>(employeeRepository.findEmployeeBySalaryJPQL(salary), HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<?> findeEmployeeBySalarySQL(double salary) {
		return new ResponseEntity<>(employeeRepository.findEmployeeBySalarySQL(salary), HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<?> findBySalaryGreaterThan(double salary) {
		return new ResponseEntity<>(employeeRepository.findBySalaryGreaterThan(salary), HttpStatus.FOUND);
	}

	@Override
	public Optional<Double> avgSalary() {
		return employeeRepository.avgSalary();
	}

	@Override
	public ResponseEntity<?> findEmployeeBySalaryWithSorting(String name) {
		List<Employee> all = employeeRepository.findAll(Sort.by(Direction.ASC, name));
		return new ResponseEntity<>(all, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> findEmployeeByNameWithPagination(int pagenumber, int pagesize) {
		Page<Employee> all = employeeRepository.findAll(PageRequest.of(pagenumber, pagesize));
		return new ResponseEntity<>(all, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> findEmployeeByNameWithPaginationandSorting(int pagenumber, int pagesize, String name) {
		Page<Employee> all = employeeRepository
				.findAll(PageRequest.of(pagenumber, pagesize, Sort.by(Direction.ASC, name)));
		return new ResponseEntity<>(all, HttpStatus.OK);
	}

}

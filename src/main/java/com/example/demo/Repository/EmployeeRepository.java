package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	List<Employee>  findAllById(Long id);

	List<Employee> findByName(String name);

//	boolean exists(EmployeeEntity employeeEntity);
	 

	 void deleteById(Long id) ;
	 
	 List<Employee> findBySalary(double salary);
	 
	 //Filter by salary : 1. methodname ,2 query:jpql , sql , 
	 
	 List<Employee> findEmployeeBySalary(double salary);
	 
	 @Query(value = "Select e from Employee e where  e.salary> :salary")
	 List<Employee> findEmployeeBySalaryJPQL(double salary);
	 
	 @Query(value = "Select * from Employee where e.salary>?1",nativeQuery = true)
	 List<Employee> findEmployeeBySalarySQL(@Param("salary") double salary);
	
  
	 List<Employee> findBySalaryGreaterThan(double salary);
	 
	 List<Employee> findByAgeBetween(int min,int max);
	 
	 
	 @Query(value =  "Select AVG(e.salary) from Employee e")	 
	 Optional<Double> avgSalary();
}

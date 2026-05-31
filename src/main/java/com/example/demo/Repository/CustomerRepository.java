package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Customer;
import com.example.demo.dto.CustomerDtoResponse;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query(value ="Select c.custName ,Count(o) from Customer c Join c.orders o GROUP BY c.id ")
    //join query
 //   @Query(value = "SELECT c.name , COUNT(o) FROM Customer c JOIN c.orders o GROUP BY c.id")
	List<Object[]> findCustomerwithOrderCount();
	
	@Query(value  = "Select NEW com.example.demo.dto.CustomerDtoResponse(c.custName,Count(o), SUM(o.price)) FROM Customer c JOIN c.orders o GROUP BY c.id")
   // @Query(value = "SELECT  NEW com.javatechie.common.CustomerOrderDTO(c.name , COUNT(o), SUM(o.price)) FROM Customer c JOIN c.orders o GROUP BY c.id")
	List<CustomerDtoResponse> findCustomerOrderCountResponse();
}

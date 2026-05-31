package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Customer;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Repository.OrderRepository;
import com.example.demo.dto.CustomerDtoResponse;
import com.example.demo.dto.OrderRequest;

@Service
public class CustomerServiceimpl {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	public ResponseEntity<?> createOrder(OrderRequest order) {
		//get the order & save the order
	   Customer customer =(Customer) order.getCustomer();     //customer= id,name,email,listoforders
	   
	   customer.getOrders().forEach(c-> c.setCustomer(customer));
	   
	   Customer save = customerRepository.save(customer);
	   
	   return new ResponseEntity<>(save, HttpStatus.OK);
		
		
	}
	
	
	public List<CustomerDtoResponse> findCustomerOrderCountResponse() {
		List<CustomerDtoResponse> customerOrderCountResponse = customerRepository.findCustomerOrderCountResponse();
		return customerOrderCountResponse ;
	}
	
	public List<Object[]> findCustomerOrderCount() {
		List<Object[]> customerOrderCountResponse = customerRepository.findCustomerwithOrderCount();
		return customerOrderCountResponse;
	}
}

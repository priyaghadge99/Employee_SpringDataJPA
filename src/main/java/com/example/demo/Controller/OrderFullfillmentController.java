package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Customer;
import com.example.demo.Service.CustomerServiceimpl;
import com.example.demo.dto.OrderRequest;

@RestController
@RequestMapping("/ecom")
public class OrderFullfillmentController {

	@Autowired
	private CustomerServiceimpl customerServiceimpl;

	@PostMapping("/createOrder")
	public ResponseEntity<?> getAddOrder(@RequestBody OrderRequest<Customer> order) {
		return customerServiceimpl.createOrder(order);
	}

	@GetMapping("/CustomerOrderCount")
	public ResponseEntity<?> getCustomerOrderCount() {
		return new ResponseEntity<>(customerServiceimpl.findCustomerOrderCount(),HttpStatus.FOUND);
	}
	
	@GetMapping("/CustomerOrderCountResponse")
	public ResponseEntity<?> getCustomerOrderCountResponse() {
		return new ResponseEntity<>(customerServiceimpl.findCustomerOrderCountResponse(),HttpStatus.FOUND);
	}

}

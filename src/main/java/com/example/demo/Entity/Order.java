package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Orders")
public class Order{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ordername;
	private int quantity;
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "custId")
	private Customer customer;
}


/*

Golden rule — never send "id": 0 in a POST/create request. Either omit id entirely or send "id": null. JPA only auto-generates ID when the field is null, not 0
{
  "customer": {
    "custName": "Priya Ghadge",
    "emailId": "priyaghadge59@gmail.com",
    "orders": [
      {
        "ordername": "Laptop",
        "quantity": 1,
        "price": 67000.20
        
        
      }
    ]
  }
}
*/
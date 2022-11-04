package com.lv2code.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lv2code.dto.CustomerDTO;
import com.lv2code.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/customers")
@Api(value = "CustomerController, REST APIs that deal with Customer DTO")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(produces = "application/json")
	@ApiOperation(value = "Fetch all the customers of Infytel", response = CustomerDTO.class, tags = "fetchCustomer")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Fetched the customers successfully"), 
							@ApiResponse(code = 404, message = "Customer details not found") })
	public List<CustomerDTO> fetchCustomer() {
		return customerService.fetchCustomer();
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<String> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
		return ResponseEntity.ok(customerService.createCustomer(customerDTO));
	}
	
	

}

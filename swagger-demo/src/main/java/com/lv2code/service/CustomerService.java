package com.lv2code.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lv2code.dto.CustomerDTO;
import com.lv2code.exceptions.NoSuchCustomerException;
import com.lv2code.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public String createCustomer(CustomerDTO customerDTO) {
		return customerRepository.createCustomer(customerDTO);
	}
	
	public List<CustomerDTO> fetchCustomer() {
		List<CustomerDTO> customers = customerRepository.fetchCustomer();
		return customers.stream().map(c -> {c.setPassword("*"); return c;}).collect(Collectors.toList());
	}
	
	public String deleteCustomer(long phoneNumber) throws NoSuchCustomerException {
		return customerRepository.deleteCustomer(phoneNumber);
	}
	
	public String updateCustomer(long phoneNumber, CustomerDTO customerDTO) throws NoSuchCustomerException {
		return customerRepository.updateCustomer(phoneNumber, customerDTO);
	}
}

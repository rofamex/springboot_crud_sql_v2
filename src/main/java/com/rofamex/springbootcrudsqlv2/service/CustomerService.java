package com.rofamex.springbootcrudsqlv2.service;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rofamex.springbootcrudsqlv2.entity.Customer;
import com.rofamex.springbootcrudsqlv2.repository.CustomerRepository;

@Service
public class CustomerService {
	private static final Logger LOG = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	CustomerRepository customerRepository;

	public List<Customer> selectAll() {
		List<Customer> customers = customerRepository.findAll();

		for (Iterator<Customer> iterator = customers.iterator(); iterator.hasNext();) {
			Customer customer = iterator.next();
			LOG.info("customerId= {}, customerName = {}, customerAge = {}", customer.getId(), customer.getName(), customer.getAge());
		}
		
		return customers;

	}

}

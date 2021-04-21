package com.rofamex.springbootcrudsqlv2.service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
	
	public Collection<Customer> findByJpql() {
		return customerRepository.findByJpql();
	}
	
	public Collection<Customer> findByNativeQuery() {
		return customerRepository.findByNativeQuery();
	}

	public List<Customer> findAllConsole() {
		List<Customer> customers = customerRepository.findAll();

		for (Iterator<Customer> iterator = customers.iterator(); iterator.hasNext();) {
			Customer customer = iterator.next();
			LOG.debug("customerId= {}, customerName = {}, customerAge = {}", customer.getId(), customer.getName(), customer.getAge());
		}

		return customers;
	}

	public Optional<Customer> findById(Long id) {
		return customerRepository.findById(id);
	}

	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	public void saveAll(List<Customer> customers) {
		customerRepository.saveAll(customers);
	}

	public void deleteById(Long customersId) {
		customerRepository.deleteById(customersId);
	}

	public void deleteByIds(List<Long> customersListIds) {
		for (Iterator<Long> iterator = customersListIds.iterator(); iterator.hasNext();) {
			Long id = iterator.next();
			customerRepository.deleteById(id);
		}
	}

}

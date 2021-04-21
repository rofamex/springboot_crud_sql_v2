package com.rofamex.springbootcrudsqlv2.repository.IQuery;

import java.util.List;

import com.rofamex.springbootcrudsqlv2.entity.Customer;

public interface CustomerDetailIQuery {
	List<Customer> findByEntityManagerJpql();
}

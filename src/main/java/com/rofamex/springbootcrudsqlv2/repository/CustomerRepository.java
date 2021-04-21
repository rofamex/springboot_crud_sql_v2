package com.rofamex.springbootcrudsqlv2.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rofamex.springbootcrudsqlv2.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
//	JPQL queries
//	@Query("SELECT c FROM Customer c")
	@Query("SELECT c FROM Customer c order by name")
	Collection<Customer> findByJpql();
	
//	Native queries
//	@Query(value = "SELECT * FROM CUSTOMER", nativeQuery = true)
	@Query(value = "SELECT * FROM CUSTOMER c WHERE c.age = 25", nativeQuery = true)
	Collection<Customer> findByNativeQuery();
}

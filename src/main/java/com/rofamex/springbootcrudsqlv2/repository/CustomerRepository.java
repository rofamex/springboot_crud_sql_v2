package com.rofamex.springbootcrudsqlv2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rofamex.springbootcrudsqlv2.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

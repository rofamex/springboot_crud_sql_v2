package com.rofamex.springbootcrudsqlv2.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rofamex.springbootcrudsqlv2.service.CustomerService;


public class MainRoute {

	@Autowired
	CustomerService customerService;

	public MainRoute() {
		customerService.selectAll();
	}

}

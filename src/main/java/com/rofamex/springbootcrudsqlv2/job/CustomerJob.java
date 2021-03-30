package com.rofamex.springbootcrudsqlv2.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.rofamex.springbootcrudsqlv2.service.CustomerService;

/*
@EnableAsync
@Component
*/
public class CustomerJob {
	private static final Logger LOG = LoggerFactory.getLogger(CustomerJob.class);

	@Autowired
	private CustomerService customerService;

	@Async
	@Scheduled(fixedRateString = "10000", initialDelayString = "1000")
	protected void selectAll() {
		customerService.selectAll();
	}
}

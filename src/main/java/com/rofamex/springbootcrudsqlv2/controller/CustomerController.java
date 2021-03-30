package com.rofamex.springbootcrudsqlv2.controller;

import static java.util.Objects.isNull;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.rofamex.springbootcrudsqlv2.entity.Customer;
import com.rofamex.springbootcrudsqlv2.service.CustomerService;

@RestController
public class CustomerController {
	private static Gson gson = new Gson();
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> findAll() {
		JsonObject jsonMessage = new JsonObject();
		String message;
		try {
			List<Customer> customers = customerService.selectAll();
			JsonElement jsonElement = gson.toJsonTree(customers);
			
			return ResponseEntity.status(HttpStatus.OK).body(jsonElement.toString());
		} catch (Exception e) {
			message = e.getMessage() + (isNull(e.getCause()) ? "" : e.getCause().getMessage());
			jsonMessage.add("erro", new JsonPrimitive(message));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonMessage.toString());
		}
	}
	
}

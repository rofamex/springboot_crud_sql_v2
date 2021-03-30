package com.rofamex.springbootcrudsqlv2.controller;

import static java.util.Objects.isNull;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
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
			List<Customer> customers = customerService.findAll();
			JsonElement jsonElement = gson.toJsonTree(customers);

			return ResponseEntity.status(HttpStatus.OK).body(jsonElement.toString());
		} catch (Exception e) {
			message = e.getMessage() + (isNull(e.getCause()) ? "" : e.getCause().getMessage());
			jsonMessage.add("error", new JsonPrimitive(message));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonMessage.toString());
		}
	}

	@PostMapping(value = "/saveAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveAll(@RequestBody String jsonString) {
		JsonObject jsonMessage = new JsonObject();
		String message;
		try {
			Type type = new TypeToken<Map<String, List<Customer>>>() {
			}.getType();
			Map<String, List<Customer>> mapResponse = gson.fromJson(jsonString, type);
			List<Customer> customersList = mapResponse.get("customers");
			customerService.saveAll(customersList);

			message = "Successfully created";
			jsonMessage.add("message", new JsonPrimitive(message));
			return ResponseEntity.status(HttpStatus.OK).body(jsonMessage.toString());
		} catch (Exception e) {
			message = e.getMessage() + (isNull(e.getCause()) ? "" : e.getCause().getMessage());
			jsonMessage.add("error", new JsonPrimitive(message));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonMessage.toString());
		}
	}

	@PutMapping(value = "/updateById", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateById(@RequestBody String jsonString) {
		JsonObject jsonMessage = new JsonObject();
		String message;
		try {
			Type type = new TypeToken<Map<String, Customer>>() {
			}.getType();
			Map<String, Customer> mapResponse = gson.fromJson(jsonString, type);
			Customer customer = mapResponse.get("customer");
			customerService.save(customer);
			
			message = "Successfully updated";
			jsonMessage.add("message", new JsonPrimitive(message));

			return ResponseEntity.status(HttpStatus.OK).body(jsonMessage.toString());
		} catch (Exception e) {
			message = e.getMessage() + (isNull(e.getCause()) ? "" : e.getCause().getMessage());
			jsonMessage.add("error", new JsonPrimitive(message));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonMessage.toString());
		}
	}

	@DeleteMapping(value = "/deleteById", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteById(@RequestBody String jsonString) {
		JsonObject jsonMessage = new JsonObject();
		String message;
		try {
			Type type = new TypeToken<Map<String, Long>>() {
			}.getType();
			Map<String, Long> mapResponse = gson.fromJson(jsonString, type);
			Long customerId = mapResponse.get("id");
			customerService.deleteById(customerId);

			message = "Successfully deleted";
			jsonMessage.add("message", new JsonPrimitive(message));

			return ResponseEntity.status(HttpStatus.OK).body(jsonMessage.toString());
		} catch (Exception e) {
			message = e.getMessage() + (isNull(e.getCause()) ? "" : e.getCause().getMessage());
			jsonMessage.add("error", new JsonPrimitive(message));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonMessage.toString());
		}
	}

	@DeleteMapping(value = "/deleteByIds", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteByIds(@RequestBody String jsonString) {
		JsonObject jsonMessage = new JsonObject();
		String message;
		try {
			Type type = new TypeToken<Map<String, List<Long>>>() {
			}.getType();
			Map<String, List<Long>> mapResponse = gson.fromJson(jsonString, type);
			List<Long> customerListIds = mapResponse.get("ids");
			customerService.deleteByIds(customerListIds);

			message = "Successfully deleted";
			jsonMessage.add("message", new JsonPrimitive(message));

			return ResponseEntity.status(HttpStatus.OK).body(jsonMessage.toString());
		} catch (Exception e) {
			message = e.getMessage() + (isNull(e.getCause()) ? "" : e.getCause().getMessage());
			jsonMessage.add("error", new JsonPrimitive(message));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonMessage.toString());
		}
	}

}

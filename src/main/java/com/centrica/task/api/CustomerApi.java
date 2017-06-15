/**
 * 
 */
package com.centrica.task.api;

import org.springframework.http.ResponseEntity;

import com.centrica.task.api.model.Customer;

/**
 * Greeting api interface definition
 * 
 * @author wemccl
 *
 */
public interface CustomerApi {

	/**
	 * Greeting api method to return greeting
	 * 
	 * @return
	 */
	public ResponseEntity<Customer> getCustomer(String customerId);

}

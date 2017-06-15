/**
 * 
 */
package com.centrica.task.api.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.centrica.task.api.CustomerApi;
import com.centrica.task.api.model.Customer;
import com.centrica.task.service.CustomerService;

/**
 * Public greeting api endpoint controller, implementing greetings interface for public
 * 
 * @author wemccl
 *
 */
@RestController
@RequestMapping("/customer")
public class CustomerController implements CustomerApi {

	@Autowired
	CustomerService customerService ;
	
	@RequestMapping(value = "/{customerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Customer> getCustomer (@PathVariable("customerId") String customerId) {
		return new ResponseEntity<Customer>(customerService.getCustomer(customerId), HttpStatus.OK) ;
	}
    
}
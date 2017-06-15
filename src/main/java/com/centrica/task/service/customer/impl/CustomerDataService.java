/**
 * 
 */
package com.centrica.task.service.customer.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.centrica.task.api.model.Customer;
import com.centrica.task.api.model.Promotion;
import com.centrica.task.gateway.MessageGateway;
import com.centrica.task.gateway.MessageService;
import com.centrica.task.service.CustomerService;

/**
 * @author wemccl
 *
 */
@Component
public class CustomerDataService implements CustomerService {

	private static final Logger log = LoggerFactory.getLogger(CustomerDataService.class);
	
	@Autowired
	MessageGateway messageGateway ;
	
    /**
     * 
     */
	public Customer getCustomer(String customerId) {
		Customer customer = getCustomerById(customerId) ;
		// Place message on queue.. and initiate retrieve.... blocking until done
		Promotion promotion = messageGateway.retrievePromotionForCustomerById(customerId) ;
		customer.setPromotion(promotion.getMessage());
		return customer;
	}

	/**
	 * 
	 * @param customerId
	 * @return
	 */
	private Customer getCustomerById( String customerId ) {
		// Get employee.. in 'real situation this would involve query via DAO to customer db
		Customer customer = new Customer(customerId);
		customer.setName("Richard James");
		return customer ;
	}
	
}

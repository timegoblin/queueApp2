/**
 * 
 */
package com.centrica.task.gateway;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centrica.task.api.model.Promotion;
import com.centrica.task.gateway.model.CustomerMessage;
import com.centrica.task.gateway.model.PromotionMessage;

/**
 * @author wemccl
 *
 */
@Service
public class MessageGatewayService extends MessageService implements MessageGateway {

    private static final Logger log = LoggerFactory.getLogger(MessageGatewayService.class);

    /**
     * 
     */
	public Promotion retrievePromotionForCustomerById(String customerId) {
        final CustomerMessage message = new CustomerMessage(customerId, new Random().nextInt(50), false);
        log.info("Sending customer message...");
        //Object x = rabbitTemplate.convertSendAndReceive(DataQueueService.EXCHANGE_NAME, DataQueueService.ROUTING_KEY, message);
        rabbitTemplate.convertAndSend(MessageService.EXCHANGE_NAME, MessageService.ROUTING_KEY, message);
        PromotionMessage promotionMsg = (PromotionMessage) rabbitTemplate.receiveAndConvert(MessageService.PROMOTION_QUEUE, 5000) ;
		Promotion promotion = new Promotion(promotionMsg.getText()) ;

        if ( null != promotion ) {
        	log.info(" Received promotion reply :- " + promotion.toString());
        }
		return promotion ;
	}
    
}
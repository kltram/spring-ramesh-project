package com.seekerscapital.sp.mainclass.controller;

import java.security.Principal;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.seekerscapital.sp.model.Price;
import com.seekerscapital.sp.util.AverageCalculatorUtil;
import com.seekerscapital.sp.util.LoggerUtil;
import com.seekerscapital.sp.util.LoggingUtil;

/**
 * @author Ramesh
 * @since 1.0
 * @version Revision History
 * WebSocketController
 *<pre>
 * --------------------------------------------------------
 * Version |By            |Date          |Modification
 * -------------------------------------------------------- 
 * 1.0     |Ramesh       |2018-04-08    |Create
 * </pre>
 */
@Controller
public class WebSocketController {
	Price priceObj = new Price();
	AverageCalculatorUtil averageCalUtil = new AverageCalculatorUtil();
	private static Logger log = LoggerUtil.getServiceLogger();
	@Autowired
	private SimpMessageSendingOperations messagingTemplate;

	@MessageMapping("/message")
	@SendToUser("/queue/reply")
	public Price processMessageFromClient(@Payload String message,Principal principal) throws Exception {
		LoggingUtil.logEnteringMethod("WebSocketController", "processMessageFromClient", log);
		String price = new Gson().fromJson(message, Map.class).get("price").toString();
		
		priceObj.setLastPrice(Integer.parseInt(price));
		priceObj.setListPrice(Integer.parseInt(price));
		int avgVal = averageCalUtil.getAveragePrice(priceObj.getListPrice());
		priceObj.setAveragePrice(avgVal);
		//messagingTemplate.convertAndSendToUser(principal.getName(), "/queue/reply", name);
		LoggingUtil.logExitingMethod("WebSocketController", "processMessageFromClient", log);
		return priceObj;
	}
	
	@MessageExceptionHandler
    @SendToUser("/queue/errors")
    public String handleException(Throwable exception) {
		LoggingUtil.logEnteringMethod("WebSocketController", "handleException", log);
        return exception.getMessage();
    }

}

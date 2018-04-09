package com.seekerscapital.sp.mainclass;
import com.seekerscapital.sp.constant.ServiceConstant;
import com.seekerscapital.sp.util.LoggerUtil;
import com.seekerscapital.sp.util.LoggingUtil;

import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;




/**
 * @author Ramesh
 * @since 1.0
 * @version Revision History
 * 
 *<pre>
 * --------------------------------------------------------
 * Version |By            |Date          |Modification
 * -------------------------------------------------------- 
 * 1.0     |Ramesh       |2018-04-08    |Create
 * </pre>
 */

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
	private static Logger log = LoggerUtil.getServiceLogger();
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		LoggingUtil.logEnteringMethod("WebSocketConfig", "configureMessageBroker", log);
		config.enableSimpleBroker(ServiceConstant.MESSAGE_TOPIC.trim(), ServiceConstant.MESSAGE_QUEUE.trim());
		config.setApplicationDestinationPrefixes(ServiceConstant.APP_PREFIX.trim());
		LoggingUtil.logExitingMethod("WebSocketConfig", "configureMessageBroker", log);
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		LoggingUtil.logEnteringMethod("WebSocketConfig", "registerStompEndpoints", log);
		registry.addEndpoint(ServiceConstant.REG_ENDPOINT.trim());
		LoggingUtil.logExitingMethod("WebSocketConfig", "configureMessageBroker", log);
	}

}
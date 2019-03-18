package com.project.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import static com.project.api.constants.Constants.SECURED_CHAT_ROOM;
import static com.project.api.constants.Constants.SECURED_CHAT_SPECIFIC_USER;
import static com.project.api.constants.Constants.SECURED_USER;
import static com.project.api.constants.Constants.SECURITY_MVC_SOCKET;


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) { 
    registry.addEndpoint(SECURED_CHAT_ROOM).withSockJS();
  }

  @Override
  public void configureMessageBroker(MessageBrokerRegistry config) {
    config.enableSimpleBroker(SECURED_CHAT_SPECIFIC_USER);
    config.setApplicationDestinationPrefixes(SECURITY_MVC_SOCKET);
    config.setUserDestinationPrefix(SECURED_USER);
  }

}
package com.project.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.Header;

import com.project.api.models.Message;
import com.project.api.models.OutputMessage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.security.Principal;


import static com.project.api.constants.Constants.SECURED_CHAT_ROOM;
import static com.project.api.constants.Constants.SECURED_CHAT_SPECIFIC_USER;


@Controller
public class SocketController {

  @Autowired
  private SimpMessagingTemplate simpMessagingTemplate;

  @MessageMapping(SECURED_CHAT_ROOM)
  public void sendDirectMessage(@Payload Message message, Principal user, 
                                @Header("simpSessionId") String sessionId) 
                                throws Exception{

    OutputMessage out = new OutputMessage(
      message.getFrom(), 
      message.getText(), 
      new SimpleDateFormat("HH:mm").format(new Date()));

      simpMessagingTemplate.convertAndSendToUser(message.getTo(), SECURED_CHAT_SPECIFIC_USER ,out);
    

  }

}
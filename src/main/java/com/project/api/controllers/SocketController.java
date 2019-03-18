package com.project.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.Header;
import java.security.Principal;

import com.project.api.models.Message;

import static com.project.api.constants.Constants.SECURED_CHAT_ROOM;

@Controller
public class SocketController {

  @Autowired
  private SimpMessagingTemplate simpMessagingTemplate;

  @MessageMapping(SECURED_CHAT_ROOM)
  public void sendDirectMessage(@Payload Message message, Principal user, @Header("simpSessionId") String sessionId) throws Exception{

  }

}
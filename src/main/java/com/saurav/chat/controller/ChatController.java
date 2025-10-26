package com.saurav.chat.controller;

import com.saurav.chat.entity.Message;
import com.saurav.chat.payload.MessageRequest;
import com.saurav.chat.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ChatController {

    @Autowired
    private ChatService chatService;


    @MessageMapping("/sendmessage/{roomId}")
    @SendTo("/topic/room/{roomId}")//client will subscribe
    public Message sendMessage(
            @DestinationVariable String roomId,
            @RequestBody MessageRequest messageRequest){

        return chatService.sendMessage(roomId,messageRequest);

    }
}

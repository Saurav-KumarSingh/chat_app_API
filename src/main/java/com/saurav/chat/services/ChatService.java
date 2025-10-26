package com.saurav.chat.services;

import com.saurav.chat.entity.Message;
import com.saurav.chat.entity.Room;
import com.saurav.chat.payload.MessageRequest;
import com.saurav.chat.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ChatService {

    @Autowired
    private RoomRepository roomRepository;

    public Message sendMessage(String roomId, MessageRequest messageRequest) {

        Room room=roomRepository.findByRoomId(messageRequest.getRoomId());

        Message message=new Message();
        message.setContent(messageRequest.getContent());
        message.setSender(messageRequest.getSender());
        message.setTimeStamp(LocalDateTime.now());

        if (room!=null){
            room.getMessages().add(message);
            roomRepository.save(room);

        }else {
            throw new RuntimeException("room not found !!");
        }

        return message;

    }
}

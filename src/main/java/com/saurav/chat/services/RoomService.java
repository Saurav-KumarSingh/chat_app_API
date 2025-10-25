package com.saurav.chat.services;

import com.saurav.chat.entity.Message;
import com.saurav.chat.entity.Room;
import com.saurav.chat.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public ResponseEntity<?> createRoom(String roomId) {
        if(roomRepository.findByRoomId(roomId)!=null){
            return ResponseEntity.badRequest().body("Room already exists!");
        }

        Room room=new Room();

        room.setRoomId(roomId);
        Room savedRoom=roomRepository.save(room);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedRoom);
    }

    public ResponseEntity<?> joinRoom(String roomId) {

        Room room= roomRepository.findByRoomId(roomId);

        if(room==null){
            return ResponseEntity.badRequest().body("Room not found!");
        }
        return ResponseEntity.ok(room);
    }

    public ResponseEntity<List<Message>> getMessages(String roomId) {
        Room room=roomRepository.findByRoomId(roomId);

        if(room==null){
            return ResponseEntity.badRequest().build();
        }

        List<Message> messages=room.getMessages();
        return ResponseEntity.ok(messages);
    }
}

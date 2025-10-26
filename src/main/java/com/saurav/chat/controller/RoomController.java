package com.saurav.chat.controller;

import com.saurav.chat.entity.Message;
import com.saurav.chat.entity.Room;
import com.saurav.chat.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
@CrossOrigin("*")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody String roomId){
            return roomService.createRoom(roomId);
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<?> joinRoom(@PathVariable String roomId){
        return roomService.joinRoom(roomId);
    }

    //get messages
    @GetMapping("/{roomId}/messages")
    public ResponseEntity<List<Message>> getMessages(@PathVariable String roomId){
        return roomService.getMessages(roomId);
    }
}

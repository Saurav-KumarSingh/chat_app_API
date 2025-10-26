package com.saurav.chat.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {
    private Long sender;
    private String content;
    private LocalDateTime messageTime;
    private String roomId;
}

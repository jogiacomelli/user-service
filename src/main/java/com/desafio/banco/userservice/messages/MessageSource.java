package com.desafio.banco.userservice.messages;


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MessageSource {

    @Output("user-channel")
    MessageChannel sendMessage();

}

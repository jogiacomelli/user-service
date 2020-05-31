package com.desafio.banco.userservice.messages;

import com.desafio.banco.userservice.model.User;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    public boolean sendMessage(User user, MessageSource source) {
        Message<User> message = MessageBuilder.withPayload(user).build();

        return source.sendMessage().send(message);
    }

}

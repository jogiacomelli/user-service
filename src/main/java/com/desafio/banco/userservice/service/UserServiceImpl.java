package com.desafio.banco.userservice.service;

import com.desafio.banco.userservice.messages.MessageSender;
import com.desafio.banco.userservice.messages.MessageSource;
import com.desafio.banco.userservice.model.User;
import com.desafio.banco.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private MessageSender producer;

    @Autowired
    private MessageSource source;

    @Override
    public User add(User user) {
        User newUser = repository.save(user);
        producer.sendMessage(newUser, source);

        return newUser;
    }

    @Override
    public List<User> add(List<User> users) {
        return repository.saveAll(users);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<User> get(Long id) {
        return repository.findById(id);
    }

    @Override
    public User update(User user) {
        return repository.save(user);
    }

    @Override
    public Long delete(User user) {
        repository.delete(user);

        return user.getDocument();
    }

    @Override
    public Long delete(Long id) {
        delete(get(id).orElseThrow(() -> new RuntimeException("User not found.")));

        return id;
    }
}

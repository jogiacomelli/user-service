package com.desafio.banco.userservice.controller;

import com.desafio.banco.userservice.messages.MessageSender;
import com.desafio.banco.userservice.messages.MessageSource;
import com.desafio.banco.userservice.model.User;
import com.desafio.banco.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Autowired
    private MessageSource source;

    @Autowired
    private MessageSender producer;

    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user) {
        User newUser = service.add(user);

        return ResponseEntity.ok().body(newUser);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> get(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.get(id).orElseThrow(() -> new RuntimeException("User not Found")));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.delete(id));
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        return ResponseEntity.ok().body(service.update(user));
    }

}

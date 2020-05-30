package com.desafio.banco.userservice.service;

import com.desafio.banco.userservice.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User add(User user);

    List<User> add(List<User> users);

    List<User> getAll();

    Optional<User> get(Long id);

    User update(User user);

    Long delete(User user);

    Long delete(Long id);
}

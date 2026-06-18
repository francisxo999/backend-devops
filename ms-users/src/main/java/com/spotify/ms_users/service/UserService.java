package com.spotify.ms_users.service;

import com.spotify.ms_users.model.User;
import com.spotify.ms_users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> listarTodos() {
        return repository.findAll();
    }

    public User guardar(User user) {
        return repository.save(user);
    }
}
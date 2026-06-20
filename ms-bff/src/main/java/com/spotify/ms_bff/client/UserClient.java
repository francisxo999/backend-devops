package com.spotify.ms_bff.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Map;

@FeignClient(name = "ms-users")
public interface UserClient {
    @GetMapping("/users")
    List<Object> getUsers();

    @PostMapping("/users")
    Object saveUser(@RequestBody Object user);

    // Método simple para buscar un usuario por email (para el "login")
    @GetMapping("/users/search")
    Object findByEmail(@RequestParam("email") String email);

    @PostMapping("/users/login")
    Object loginUser(@RequestBody Map<String, String> credentials);
}
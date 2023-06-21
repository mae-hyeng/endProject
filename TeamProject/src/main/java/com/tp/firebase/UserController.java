package com.tp.firebase;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.tp.service.UserService;

public class UserController {

	private final UserService userService = new UserService();

    @GetMapping("/users")
    public ResponseEntity<Object>  getUsers() throws ExecutionException, InterruptedException {
        List<User> list = userService.getByCredentials();
        return ResponseEntity.ok().body(list);

    }
    
}

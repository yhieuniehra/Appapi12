package com.example.Appapi12.controller;

import com.example.Appapi12.model.User;
import com.example.Appapi12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {

    @Autowired
    private UserService userService;

    //1. Get All - Trả về danh sách User
    @GetMapping("/users")
    @ResponseBody
    public List<User> getUserList() {

        return userService.findAll();
    }

    //2. Get by id - Trả về một User cụ thể theo ID
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
        User user = (User) userService.findById(userId);
        if (user != null) {
            return ResponseEntity.status(200).body(user);
        }
        return ResponseEntity.status(404).body(null);  // Trả về lỗi 404 nếu không tìm thấy
    }

    //3. Xóa User theo ID
    @DeleteMapping("/users/{id}")
    @ResponseBody
    public List<User> removeUserById(@PathVariable("id") Long userId) {
        userService.delete(userId);
        return userService.findAll();
    }

    //4. Tạo mới User
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.save((User) user);
        return ResponseEntity.status(201).body(user);
    }

    //5. Cập nhật User
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody User updateUser) {
        User user = (User) userService.findById(userId);
        if (user != null) {
            user.setName(updateUser.getName());
            user.setEmail(updateUser.getEmail());
            userService.save((User) user);
            return ResponseEntity.status(200).body(user);
        }
        return ResponseEntity.status(404).body(null);
    }
}

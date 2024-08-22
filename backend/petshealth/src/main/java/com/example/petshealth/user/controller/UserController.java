package com.example.petshealth.user.controller;

import com.example.petshealth.pet.model.Pet;
import com.example.petshealth.user.dto.UserLoginDto;
import com.example.petshealth.user.dto.UserRegistrationDto;
import com.example.petshealth.user.model.User;
import com.example.petshealth.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<Long> authorizeAnUser(@RequestBody UserLoginDto userDTO){

        return ResponseEntity.ok(userService.authorizeAnUser(userDTO));
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUsers(@RequestBody UserRegistrationDto request){
        return ResponseEntity.ok(userService.registerUsers(request));
    }

    @GetMapping("/pets/{id}")
    public ResponseEntity<List<Pet>> listUsersPets(@PathVariable Long id){
        return ResponseEntity.ok(userService.listUsersPets(id));

    }
}

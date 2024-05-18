package com.VeraRchik.bankapplication.contoller;

import com.VeraRchik.bankapplication.dto.UserDto;
import com.VeraRchik.bankapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vBank/personalAccount")
@CrossOrigin(origins = "http://147.45.150.25:3000")
//@CrossOrigin(origins = "http://localhost:3000")
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long userId) {
        UserDto user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

}
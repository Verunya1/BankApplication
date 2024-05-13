package com.VeraRchik.bankapplication.contoller;

import com.VeraRchik.bankapplication.config.UserAuthenticationProvider;
import com.VeraRchik.bankapplication.dto.CredentialsDto;
import com.VeraRchik.bankapplication.dto.SignUpDto;
//import com.VeraRchik.bankapplication.dto.UserDto;
import com.VeraRchik.bankapplication.dto.UserDto;
import com.VeraRchik.bankapplication.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import java.net.URI;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/vBank/auth")
public class AuthController {

    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;


    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid CredentialsDto credentialsDto) {
        UserDto userDto = userService.login(credentialsDto);
        userDto.setToken(userAuthenticationProvider.createToken(userDto));
        log.info("Пользователь {} вошел в систему",userDto);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid SignUpDto user) {
        UserDto createdUser = userService.register(user);
        createdUser.setToken(userAuthenticationProvider.createToken(createdUser));
        log.info("Пользователь {} зарегистрировался в систему",createdUser);

        return ResponseEntity.created(URI.create("/personalAccount/" + createdUser.getId())).body(createdUser);
    }

}
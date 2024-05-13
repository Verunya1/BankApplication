package com.VeraRchik.bankapplication.service;

import com.VeraRchik.bankapplication.dto.CredentialsDto;
import com.VeraRchik.bankapplication.dto.SignUpDto;
import com.VeraRchik.bankapplication.dto.UserDto;
import com.VeraRchik.bankapplication.entity.User;
import com.VeraRchik.bankapplication.enums.Role;
import com.VeraRchik.bankapplication.exceptions.AppException;
import com.VeraRchik.bankapplication.mapper.UserMapper;
import com.VeraRchik.bankapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    public UserDto login(CredentialsDto credentialsDto) {
        User user = userRepository.findByLogin(credentialsDto.login())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }


    public UserDto register(SignUpDto userDto) {
        Optional<User> optionalUser = userRepository.findByLogin(userDto.login());

        if (optionalUser.isPresent()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.signUpToUser(userDto);
        user.setPhone(userDto.phone());


//        user.setRole(Role.ADMIN);
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.password())));
        log.info("user {}", user);

        User savedUser = userRepository.save(user);
        log.info("user {}", userRepository.findByLogin(user.getLogin()));
        return userMapper.toUserDto(savedUser);
    }

    public UserDto getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return userMapper.toUserDto(user);
    }
    public UserDto findByLogin(String login) {
        User user = userRepository.findByLogin(login)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }

    public boolean deleteUser(String login) {
        if (userRepository.findByLogin(login).get().getRole().equals(Role.ADMIN)) {
            return false;
        }
        userRepository.deleteByLogin(login);
        return true;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
package com.VeraRchik.bankapplication.contoller;

import com.VeraRchik.bankapplication.dto.UserDto;
import com.VeraRchik.bankapplication.entity.User;
import com.VeraRchik.bankapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vBank/personalAccount")
@CrossOrigin(origins = "http://localhost:3000")
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getWatchlist(@PathVariable Long userId) {
        UserDto user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }


//    @PostMapping("/{userId}/watchlist/{movieId}")
//    @PreAuthorize("hasAuthority('USER')")
//    public ResponseEntity<?> addMovieToWatchlist(@PathVariable String userId, @PathVariable String movieId) {
//        if (watchlistService.addMovieToWatchlist(userId, movieId)) {
//            return ResponseEntity.ok().build();
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//    }
//
//    @DeleteMapping("/{userId}/watchlist/{movieId}")
//    @PreAuthorize("hasAuthority('USER')")
//    public ResponseEntity<?> removeMovieFromWatchlist(@PathVariable String userId, @PathVariable String movieId) {
//        if (watchlistService.removeMovieFromWatchlist(userId, movieId)) {
//            return ResponseEntity.ok().build();
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//    }


//    @DeleteMapping("/ban/{login}")
//    @PreAuthorize("hasAuthority('ADMIN')")
//    public ResponseEntity<?> deleteUser(@PathVariable String login) {
//        if (userService.deleteUser(login)) {
//            return ResponseEntity.ok().build();
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//    }
//
//    @GetMapping("/ban/users")
//    @PreAuthorize("hasAuthority('ADMIN')")
//    public ResponseEntity<List<User>> getAllUsers() {
//        List<User> users = userService.findAllUsers();
//        return ResponseEntity.ok(users);
//    }
}
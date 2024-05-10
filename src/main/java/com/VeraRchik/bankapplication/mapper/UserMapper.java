package com.VeraRchik.bankapplication.mapper;


import com.VeraRchik.bankapplication.dto.SignUpDto;
import com.VeraRchik.bankapplication.dto.UserDto;
import com.VeraRchik.bankapplication.entity.User;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto.UserDtoBuilder userDto = UserDto.builder();

        if ( user.getId() != null ) {
            userDto.id( user.getId() );
        }
        userDto.firstName( user.getFirstName() );
        userDto.lastName( user.getLastName() );
        userDto.login( user.getLogin() );
        userDto.role(user.getRole());

        return userDto.build();
    }


    public User signUpToUser(SignUpDto signUpDto) {
        if ( signUpDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.firstName( signUpDto.firstName() );
        user.lastName( signUpDto.lastName() );
        user.login( signUpDto.login() );

        return user.build();
    }
}
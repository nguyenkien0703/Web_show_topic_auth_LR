package com.example.forum_web_ver_2.service.Impl;

import com.example.forum_web_ver_2.dto.UserDto;
import com.example.forum_web_ver_2.entity.Profile;
import com.example.forum_web_ver_2.entity.User;
import com.example.forum_web_ver_2.reponsitory.ProfileReponsitory;
import com.example.forum_web_ver_2.reponsitory.UserReponsitory;
import com.example.forum_web_ver_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserReponsitory userReponsitory;

    @Autowired
    private ProfileReponsitory profileReponsitory;

    @Override
    public void save(UserDto userDto) {
        LocalDateTime Date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String creationDate = Date.format(formatter);
        User user = new User(userDto.getEmail(),
                userDto.getUserDisplayName(),
                ".",
                0,
                0,
                userDto.getPassword(),
                creationDate,
                "ROLE_USER"
        );
        Profile profile=new Profile(
                "First Name",
                "Last Name",
                creationDate,
                "null",
                "Gender",
                "Adress",
                user
        );
        userReponsitory.save(user);
        profileReponsitory.save(profile);
    }

    @Override
    public Boolean checkPasswordUser(String email, String password) {
        User user = userReponsitory.findUserByEmail(email);
        if (user.getPassword().equals(password)) return true;
        return false;
    }

    @Override
    public Boolean checkUserbyEmail(String email) {
        User user = userReponsitory.findUserByEmail(email);
        if(user==null) return false;
        return true;
    }

    @Override
    public User getUserbyEmail(String email) {
        return userReponsitory.getUserByEmail(email);
    }
}

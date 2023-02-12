package com.example.forum_web_ver_2.service;

import com.example.forum_web_ver_2.dto.UserDto;
import com.example.forum_web_ver_2.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void save(UserDto userDto);
    Boolean checkPasswordUser(String email,String password);
    Boolean checkUserbyEmail(String email);
    User getUserbyEmail(String email);
}

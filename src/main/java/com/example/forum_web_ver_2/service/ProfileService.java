package com.example.forum_web_ver_2.service;

import com.example.forum_web_ver_2.dto.ProfileDto;
import com.example.forum_web_ver_2.entity.Profile;
import com.example.forum_web_ver_2.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface ProfileService {
    void update(Profile profile);
}

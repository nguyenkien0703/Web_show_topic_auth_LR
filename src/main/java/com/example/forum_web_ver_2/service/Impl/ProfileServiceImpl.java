package com.example.forum_web_ver_2.service.Impl;

import com.example.forum_web_ver_2.dto.ProfileDto;
import com.example.forum_web_ver_2.entity.Profile;
import com.example.forum_web_ver_2.entity.User;
import com.example.forum_web_ver_2.reponsitory.ProfileReponsitory;
import com.example.forum_web_ver_2.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private ProfileReponsitory profileReponsitory;

    @Override
    public void update(Profile profile) {
        profileReponsitory.save(profile);
    }
}

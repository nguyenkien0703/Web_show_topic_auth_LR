package com.example.forum_web_ver_2.service;

import com.example.forum_web_ver_2.dto.TopicDto;
import com.example.forum_web_ver_2.entity.Topic;
import com.example.forum_web_ver_2.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TopicService {
    void save(TopicDto topicDto, User user);
    Topic findTopicById(Integer id);
    void delete(Integer id);
    void update(Topic topic);
}

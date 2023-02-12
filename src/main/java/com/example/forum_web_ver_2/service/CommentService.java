package com.example.forum_web_ver_2.service;

import com.example.forum_web_ver_2.dto.CommentDto;
import com.example.forum_web_ver_2.entity.Comment;
import com.example.forum_web_ver_2.entity.Topic;
import com.example.forum_web_ver_2.entity.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public interface CommentService {
    void save(CommentDto commentDto, User user, Topic topic);
    int countComment(Topic topic);
    Comment findCommentbyId(Integer id);
    void delete(Integer topicId);

}

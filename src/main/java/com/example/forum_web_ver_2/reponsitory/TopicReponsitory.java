package com.example.forum_web_ver_2.reponsitory;

import com.example.forum_web_ver_2.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface TopicReponsitory extends JpaRepository<Topic,Integer> {
    List<Topic> getAllById(Integer id);
    Topic findTopicById(Integer id);
    void deleteById(Integer id);
    Integer countTopicByUser_ID(Integer userId);
}

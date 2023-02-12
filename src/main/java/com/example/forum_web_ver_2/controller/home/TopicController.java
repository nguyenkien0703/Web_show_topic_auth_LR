package com.example.forum_web_ver_2.controller.home;
import com.example.forum_web_ver_2.dto.CommentDto;
import com.example.forum_web_ver_2.dto.UserDto;
import com.example.forum_web_ver_2.entity.Comment;
import com.example.forum_web_ver_2.entity.Topic;
import com.example.forum_web_ver_2.entity.User;
import com.example.forum_web_ver_2.reponsitory.CommentReponsitory;
import com.example.forum_web_ver_2.reponsitory.UserReponsitory;
import com.example.forum_web_ver_2.service.CommentService;
import com.example.forum_web_ver_2.service.TopicService;
import com.example.forum_web_ver_2.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
@SessionAttributes("userdto")
public class TopicController{
    private TopicService topicService;
    private UserService userService;
    private CommentService commentService;

    @ModelAttribute("userdto")
    public UserDto userDto(){
        return new UserDto();
    }

    @Autowired
    private CommentReponsitory commentReponsitory;

    @Autowired
    private UserReponsitory userReponsitory;


    @ModelAttribute("newcomment")
    public CommentDto commentDto(){
        return new CommentDto();
    }
    @GetMapping("/topic/{id}")
    public String showTopicById(Model model, @PathVariable String id) {
        Topic topic = topicService.findTopicById(Integer.parseInt(id));
        List<Comment> comments = commentReponsitory.getAllByTopic_Id(topic.getId());
        model.addAttribute("topic", topic);
        model.addAttribute("comments", comments);
        model.addAttribute("commentcount",commentService);
        return "topic";
    }
    @PostMapping("/topic/{id}")
    public String postComment(@ModelAttribute("userdto") UserDto userDto,
                              @PathVariable String id,
                              @ModelAttribute("newcomment") CommentDto commentDto
    ) {

        Topic topic = topicService.findTopicById(Integer.parseInt(id));
        User user = userReponsitory.getUserByEmail(userDto.getEmail());
        if(user == null){
            return "redirect:/login";
        }
        commentService.save(commentDto, user, topic);
        return "redirect:/topic/"+id;
    }



}
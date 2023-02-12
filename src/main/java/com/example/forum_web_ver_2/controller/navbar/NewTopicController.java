package com.example.forum_web_ver_2.controller.navbar;

import com.example.forum_web_ver_2.dto.TopicDto;
import com.example.forum_web_ver_2.dto.UserDto;
import com.example.forum_web_ver_2.entity.User;
import com.example.forum_web_ver_2.reponsitory.UserReponsitory;
import com.example.forum_web_ver_2.service.TopicService;
import com.example.forum_web_ver_2.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@SessionAttributes("userdto")
public class NewTopicController {
    @Autowired
    private TopicService topicService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserReponsitory userReponsitory;

    @ModelAttribute("topic")
    public TopicDto topicDto(){
        return new TopicDto();
    }

    @ModelAttribute("userdto")
    public UserDto userDto(){
        return new UserDto();
    }

    @GetMapping("/newtopic")
    public String showNewTopic(Model model){
        return "/newtopic";
    }
    @PostMapping("/newtopic")
    public String newTopic(@ModelAttribute("userdto") UserDto userDto,@ModelAttribute("topic") TopicDto topicDto,Model model){
        User user = userReponsitory.getUserByEmail(userDto.getEmail());
        if(user== null){
            return "redirect:/login";
        }
        topicService.save(topicDto,user);
        return "redirect:/home";
    }
}

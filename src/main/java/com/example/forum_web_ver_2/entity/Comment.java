package com.example.forum_web_ver_2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "body", nullable = false,length=1024)
    private String Body;

    @Column(name = "creation_date", nullable = false)
    private String CreationDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    public Comment(String body, String creationDate, User user, Topic topic) {
        Body = body;
        CreationDate = creationDate;
        this.user = user;
        this.topic = topic;
    }
}

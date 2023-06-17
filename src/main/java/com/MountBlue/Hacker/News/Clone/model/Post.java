package com.MountBlue.Hacker.News.Clone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String content;
    private String createdBy;
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @OneToMany
    @JsonIgnore
    private Comment commentId;

}

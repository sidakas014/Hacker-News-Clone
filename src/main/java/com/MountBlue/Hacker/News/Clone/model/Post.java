package com.MountBlue.Hacker.News.Clone.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int postId;
    private String name;
    private String domainName;
    @Column(columnDefinition = "TEXT")
    private String content;
    private String createdBy;
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @OneToMany
    @JsonIgnore
    private List<Comment> commentId;
}

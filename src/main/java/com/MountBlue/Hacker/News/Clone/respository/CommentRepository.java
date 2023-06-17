package com.MountBlue.Hacker.News.Clone.respository;

import com.MountBlue.Hacker.News.Clone.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}

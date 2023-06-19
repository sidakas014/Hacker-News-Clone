package com.MountBlue.Hacker.News.Clone.respository;

import com.MountBlue.Hacker.News.Clone.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
    List<Post> findByNameContainingIgnoreCaseOrContentContainingIgnoreCaseOrCreatedByContainingIgnoreCase(String search, String search1, String search2);
    List<Post> findAllByDomainName(String domainName);
}

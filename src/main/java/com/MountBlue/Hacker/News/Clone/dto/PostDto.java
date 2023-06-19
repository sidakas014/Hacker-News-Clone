package com.MountBlue.Hacker.News.Clone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private String name;
    private String content;
    private String createdBy;
    private String domainName;
}

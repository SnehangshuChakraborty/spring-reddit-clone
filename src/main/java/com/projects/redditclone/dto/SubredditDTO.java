package com.projects.redditclone.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@Slf4j
@Builder
public class SubredditDTO {
    private long id;
    private String name;
    private String description;
    private Integer numberOfPosts;

}

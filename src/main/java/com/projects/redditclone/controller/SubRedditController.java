package com.projects.redditclone.controller;

import com.projects.redditclone.dto.SubredditDTO;
import com.projects.redditclone.service.SubRedditService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subreddit")
@AllArgsConstructor
@Slf4j
public class SubRedditController {

    private final SubRedditService subRedditService;

    @PostMapping
    public ResponseEntity<SubredditDTO> createSubReddit(@RequestBody SubredditDTO subredditDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(subRedditService.save(subredditDTO));
    }

    @GetMapping
    public ResponseEntity<List<SubredditDTO>> getAllSubReddit(){
        return ResponseEntity.status(HttpStatus.OK).body(subRedditService.getAll());
    }
}

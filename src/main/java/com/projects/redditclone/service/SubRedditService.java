package com.projects.redditclone.service;

import com.projects.redditclone.dto.SubredditDTO;
import com.projects.redditclone.model.Subreddit;
import com.projects.redditclone.repository.SubredditRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class SubRedditService {

    private final SubredditRepository subredditRepository;

    @Transactional
    public SubredditDTO save(SubredditDTO subredditDTO){
        Subreddit save = subredditRepository.save(mapSubRedditDto(subredditDTO));
        subredditDTO.setId(save.getId());
        return subredditDTO;
    }

    @Transactional(readOnly = true)
    public List<SubredditDTO> getAll() {
        return subredditRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(toList());
    }

    private SubredditDTO mapToDTO(Subreddit subreddit) {
        return SubredditDTO.builder()
                .name(subreddit.getName())
                .id(subreddit.getId())
                .description(subreddit.getDescription())
                .build();
    }


    private Subreddit mapSubRedditDto(SubredditDTO subredditDTO){
        return Subreddit.builder()
                .name(subredditDTO.getName())
                .description(subredditDTO.getDescription())
               .build();
    }
}

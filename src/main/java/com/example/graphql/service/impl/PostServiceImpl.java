package com.example.graphql.service.impl;

import com.example.graphql.dto.PostDto;
import com.example.graphql.entity.Post;
import com.example.graphql.mapper.PostMapper;
import com.example.graphql.service.PostService;
import java.time.Instant;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

  private final Map<UUID, Post> database = new HashMap<>();

  private final PostMapper postMapper;

  @Override
  public List<PostDto> getRecentPost(int count, int offset) {
    return database.values()
        .stream()
        .filter(Objects::nonNull)
        .sorted(Comparator.comparing(Post::getCreationTime))
        .skip(offset)
        .limit(count)
        .map(postMapper::to)
        .collect(Collectors.toList());
  }

  @Override
  public PostDto savePost(PostDto postDto) {
    Post post = postMapper.from(postDto);
    UUID id = UUID.randomUUID();
    post.setId(id);
    post.setCreationTime(Instant.now());

    database.put(id, post);

    return postMapper.to(post);
  }

  @Override
  public List<PostDto> getAuthorPosts(UUID authorId) {
    return database.values()
        .stream()
        .filter(post -> Objects.equals(authorId, post.getAuthorId()))
        .map(postMapper::to)
        .collect(Collectors.toList());
  }
}

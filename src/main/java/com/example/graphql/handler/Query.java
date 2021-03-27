package com.example.graphql.handler;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.dto.PostDto;
import com.example.graphql.service.PostService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

  private final PostService postService;

  public List<PostDto> getRecentPosts(int count, int offset) {

    log.info("Retrieve recent posts. Count '{}', offset '{}'", count, offset);
    return postService.getRecentPost(count, offset);
  }
}

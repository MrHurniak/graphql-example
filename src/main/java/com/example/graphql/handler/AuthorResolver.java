package com.example.graphql.handler;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphql.dto.AuthorDto;
import com.example.graphql.dto.PostDto;
import com.example.graphql.service.PostService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class AuthorResolver implements GraphQLResolver<AuthorDto> {

  private final PostService postService;

  public List<PostDto> getPosts(AuthorDto author) {
    return postService.getAuthorPosts(author.getId());
  }
}

package com.example.graphql.handler;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphql.dto.AuthorDto;
import com.example.graphql.dto.PostDto;
import com.example.graphql.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostResolver implements GraphQLResolver<PostDto> {

  private final AuthorService authorService;

  public AuthorDto getAuthor(PostDto post) {
    return authorService.findById(post.getAuthorId())
        .orElseThrow(RuntimeException::new);
  }
}

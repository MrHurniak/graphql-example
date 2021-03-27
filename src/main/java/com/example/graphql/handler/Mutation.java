package com.example.graphql.handler;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphql.dto.PostDto;
import com.example.graphql.service.PostService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

  private final PostService postService;

  public PostDto writePost(String title, String text, String category, String authorId) {
    PostDto postDto = new PostDto()
        .setTitle(title)
        .setText(text)
        .setCategory(category)
        .setAuthorId(UUID.fromString(authorId));

    return postService.savePost(postDto);
  }
}

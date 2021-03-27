package com.example.graphql.service;

import com.example.graphql.dto.PostDto;
import java.util.List;
import java.util.UUID;

public interface PostService {

  List<PostDto> getRecentPost(int count, int offset);

  PostDto savePost(PostDto postDto);

  List<PostDto> getAuthorPosts(UUID id);
}

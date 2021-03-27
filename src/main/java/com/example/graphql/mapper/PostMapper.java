package com.example.graphql.mapper;

import com.example.graphql.dto.PostDto;
import com.example.graphql.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = CommonMapper.class)
public interface PostMapper {

  PostDto to(Post source);

  @Mapping(target = "creationTime", ignore = true)
  Post from(PostDto source);

}

package com.example.graphql.mapper;

import com.example.graphql.dto.AuthorDto;
import com.example.graphql.entity.Author;
import org.mapstruct.Mapper;

@Mapper(config = CommonMapper.class)
public interface AuthorMapper {

  AuthorDto to(Author source);

  Author from(AuthorDto source);
}

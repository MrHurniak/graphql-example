package com.example.graphql.service.impl;

import com.example.graphql.dto.AuthorDto;
import com.example.graphql.entity.Author;
import com.example.graphql.mapper.AuthorMapper;
import com.example.graphql.service.AuthorService;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

  private final Map<UUID, Author> database = new HashMap<>();

  private final AuthorMapper authorMapper;

  @Override
  public Optional<AuthorDto> findById(UUID authorId) {
    return Optional.ofNullable(database.get(authorId))
        .map(authorMapper::to);
  }

  @Override
  public AuthorDto save(AuthorDto authorDto) {
    Author author = authorMapper.from(authorDto);
    UUID id = UUID.randomUUID();
    author.setId(id);

    database.put(id, author);

    log.info("Save author with id '{}'", id);
    return authorMapper.to(author);
  }
}

package com.example.graphql.service;

import com.example.graphql.dto.AuthorDto;
import java.util.Optional;
import java.util.UUID;

public interface AuthorService {

  Optional<AuthorDto> findById(UUID authorId);

  AuthorDto save(AuthorDto authorDto);
}

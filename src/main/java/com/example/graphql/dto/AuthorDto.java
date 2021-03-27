package com.example.graphql.dto;

import java.util.UUID;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AuthorDto {

  private UUID id;
  private String name;
  private String thumbnail;
}

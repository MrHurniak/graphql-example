package com.example.graphql.entity;

import java.util.UUID;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Author {

  private UUID id;
  private String name;
  private String thumbnail;
}

package com.example.graphql.entity;

import java.time.Instant;
import java.util.UUID;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Post {

  private UUID id;
  private String title;
  private String text;
  private String category;
  private UUID authorId;
  private Instant creationTime;
}

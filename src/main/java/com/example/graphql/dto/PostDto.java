package com.example.graphql.dto;

import java.util.UUID;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PostDto {

  private UUID id;
  private String title;
  private String text;
  private String category;
  private UUID authorId;

}

package com.hashcode.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString
public final class Photo {

   private String orientation;
   private Integer numberOfTags;
   private List<String> tags;

}

package com.hashcode.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public final class Slide {

    List<Photo> allphotos = new ArrayList();

    Set<String> hSet = new HashSet<>();

    public void addPhoto(Photo photo) {
        this.allphotos.add(photo);
        hSet = new HashSet<>(photo.getTags());
    }

    public void addPhoto(Photo photo1, Photo photo2) {
        this.allphotos.add(photo1);
        this.allphotos.add(photo2);
        hSet = new HashSet<>(photo1.getTags());
        hSet.addAll(photo2.getTags());
    }
}

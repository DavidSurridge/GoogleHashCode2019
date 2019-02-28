package com.hashcode.model;


import lombok.Data;

import java.util.ArrayList;


@Data
public final class Slide {

    ArrayList<Photo> allphotos = new ArrayList<Photo>();

    public Slide(Photo photo) {
        allphotos.add(photo);
    }

    public Slide(Photo photo1, Photo photo2) {
        allphotos.add(photo1);
        allphotos.add(photo2);
    }


}

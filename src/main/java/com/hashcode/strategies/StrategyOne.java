package com.hashcode.strategies;

import com.hashcode.model.Photo;
import com.hashcode.model.Slide;

import java.util.List;

public final class StrategyOne {

    private List<Slide> slides;

    public void runStrategy(List<Photo> photos) {
        photos.forEach(photo -> {
            if (photo.getOrientation().equalsIgnoreCase("H")) {
                final Slide slide = Slide.builder().build();
                slide.addPhoto(photo);
                slides.add(slide);
            }
        });
    }
}

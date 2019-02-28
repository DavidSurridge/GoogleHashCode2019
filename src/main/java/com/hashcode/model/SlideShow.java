package com.hashcode.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public final class SlideShow {

    private List slides = new ArrayList<Slide>();

    public void addSlide(Slide slide) {
        this.slides.add(slide);
    }

}

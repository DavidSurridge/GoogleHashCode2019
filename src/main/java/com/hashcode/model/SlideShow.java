package com.hashcode.model;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public final class SlideShow {

    List<Slide> slides = new ArrayList<Slide>();

    public SlideShow() {

    }

    public SlideShow(Slide slide) {
        this.slides.add(slide);
    }

}

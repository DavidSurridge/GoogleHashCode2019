package com.hashcode.model;

import java.util.ArrayList;
import java.util.List;

public final class SlideShow {

    List<Slide> slides = new ArrayList<Slide>();

    public SlideShow() {

    }

    public SlideShow(Slide slide) {
        this.slides.add(slide);
    }

}

package com.hashcode.strategies;

import com.hashcode.model.Photo;
import com.hashcode.model.Slide;
import com.hashcode.model.SlideShow;

import java.util.List;

public final class ExampleSolution {
    private SlideShow slideShow = new SlideShow();

    public SlideShow runStrategy(List<Photo> photos) {

        Photo photo = photos.get(0);
        final Slide slide1 = new Slide();
        slide1.addPhoto(photo);
        slideShow.addSlide(slide1);

        Photo photo1 = photos.get(3);
        final Slide slide2 = new Slide();
        slide2.addPhoto(photo1);
        slideShow.addSlide(slide2);

        Photo photo2 = photos.get(1);
        Photo photo3 = photos.get(2);
        final Slide slide3 = new Slide();
        slide3.addPhoto(photo2, photo3);

        slideShow.addSlide(slide3);

        return slideShow;
    }
}

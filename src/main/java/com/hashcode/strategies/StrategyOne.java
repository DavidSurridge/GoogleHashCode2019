package com.hashcode.strategies;

import com.hashcode.model.Photo;
import com.hashcode.model.Slide;
import com.hashcode.service.ScoreCalculator;

import java.util.List;

public final class StrategyOne {

    private List<Slide> slides;
    private Long[][] scores;

    public void runStrategy(List<Photo> photos) {
        photos.forEach(photo -> {
            if (photo.getOrientation().equalsIgnoreCase("H")) {
                final Slide slide = Slide.builder().build();
                slide.addPhoto(photo);
                slides.add(slide);
            }
        });

        scores = new Long[slides.size()][slides.size()];
    }

    private void calculateScorePairs(){
        for(int i = 0; i < slides.size(); i++) {
            final Slide firstSlide = slides.get(i);
            for (int j = i + 1; i < slides.size(); j++) {
                final Slide secondSlide = slides.get(j);
                final Long score = ScoreCalculator.getScoreBetweenTwoSlides(firstSlide, secondSlide);
                scores[i][j] = score;
                scores[j][i] = score;
            }
        }
    }
}

package com.hashcode.strategies;

import com.hashcode.model.Photo;
import com.hashcode.model.Slide;
import com.hashcode.model.SlideShow;
import com.hashcode.service.ScoreCalculator;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class StrategyOne {

    private List<Slide> slides = new ArrayList<>();
    private SlideShow slideShow = new SlideShow();

    private Set<Integer> availableSlides = new HashSet<>();
    private Long[][] scores = new Long[0][0];
    private Long bestScore = 0l;
    private BestScorePosition bestScorePosition = new BestScorePosition();

    public void runStrategy(List<Photo> photos) {
        int i = 0;

        for (Photo photo : photos) {
            if (photo.getOrientation().equalsIgnoreCase("H")) {
                final Slide slide = Slide.builder().build();
                slide.addPhoto(photo);
                slides.add(slide);
                availableSlides.add(i);
                i++;
            }
        }

        scores = new Long[slides.size()][slides.size()];
        calculateScorePairs();
        slideShow.addSlide(slides.get(bestScorePosition.i));
        slideShow.addSlide(slides.get(bestScorePosition.j));
        availableSlides.remove(bestScorePosition.i);
    }

    private void calculateScorePairs() {
        for (int i = 0; i < slides.size(); i++) {
            final Slide firstSlide = slides.get(i);
            for (int j = i + 1; j < slides.size(); j++) {
                final Slide secondSlide = slides.get(j);
                final Long score = ScoreCalculator.getScoreBetweenTwoSlides(firstSlide, secondSlide);
                scores[i][j] = score;
                scores[j][i] = score;

                if (score > bestScore) {
                    bestScore = score;
                    bestScorePosition.setI(i);
                    bestScorePosition.setJ(j);
                }
            }
        }
    }

    @Data
    @NoArgsConstructor
    private static class BestScorePosition {
        private int i = 0;
        private int j = 0;
    }
}

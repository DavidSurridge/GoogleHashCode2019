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

    private static final int MAXIMUM_VARIANCE = 10;

    private List<Slide> slides = new ArrayList<>();
    private SlideShow slideShow = new SlideShow();
    private Integer lastSlideIndex = 0;

    private Set<Integer> availableSlides = new HashSet<>();
    private Long[][] scores = new Long[0][0];
    private Long bestScore = 0l;
    private BestScorePosition bestScorePosition = new BestScorePosition();

    public SlideShow runStrategy(List<Photo> photos) {
        int i = 0;

        for (Photo photo : photos) {
            if (photo.getOrientation().equalsIgnoreCase("H")) {
                final Slide slide = new Slide();
                slide.addPhoto(photo);
                slides.add(slide);
                availableSlides.add(i);
                i++;
            }
        }

//        scores = new Long[slides.size()][slides.size()];
//        calculateScorePairs();
        lastSlideIndex = getRandomElement(availableSlides);
        slideShow.addSlide(slides.get(lastSlideIndex));
        availableSlides.remove(lastSlideIndex);

        while (availableSlides.size() > 0) {
            long localMaximumScore = 0;
            int localMaximumIndex = -1;

            for (int k = 0; k < MAXIMUM_VARIANCE; k++) {
                final Integer index = getRandomElement(availableSlides);
                final Long score = ScoreCalculator.getScoreBetweenTwoSlides(slides.get(lastSlideIndex), slides.get(index));
                if (score > localMaximumScore) {
                    localMaximumScore = score;
                    localMaximumIndex = index;
                } else if (localMaximumIndex == -1) {
                    localMaximumIndex = index;
                }
            }

//            for (Integer index : availableSlides) {
//                final Long score = scores[lastSlideIndex][index];
//                if (score > localMaximumScore) {
//                    localMaximumScore = score;
//                    localMaximumIndex = index;
//                } else if (localMaximumIndex == -1) {
//                    localMaximumIndex = index;
//                }
//            }

            if (availableSlides.size() % 1000 == 0) {
                System.out.println(localMaximumIndex + "      " + localMaximumScore + "   " + availableSlides.size());
            }
            slideShow.addSlide(slides.get(localMaximumIndex));
            availableSlides.remove(localMaximumIndex);
        }

        return slideShow;
    }

    private Integer getRandomElement(Set<Integer> availableSlides) {
        double setIndex = Math.floor(Math.random() * availableSlides.size());
        int parsedIndex = (int) setIndex;
        Integer counter = 0;

        for (Integer slide : availableSlides) {
            if (parsedIndex == counter) {
                return slide;
            }
            counter++;
        }

        return 0;
    }

//    private void calculateScorePairs() {
//        for (int i = 0; i < slides.size(); i++) {
//            final Slide firstSlide = slides.get(i);
//            for (int j = i + 1; j < slides.size(); j++) {
//                final Slide secondSlide = slides.get(j);
//                final Long score = ScoreCalculator.getScoreBetweenTwoSlides(firstSlide, secondSlide);
//                scores[i][j] = score;
//                scores[j][i] = score;
//
//                if (score > bestScore) {
//                    bestScore = score;
//                    bestScorePosition.setI(i);
//                    bestScorePosition.setJ(j);
//                }
//            }
//        }
//    }

    @Data
    @NoArgsConstructor
    private static class BestScorePosition {
        private int i = 0;
        private int j = 0;
    }
}

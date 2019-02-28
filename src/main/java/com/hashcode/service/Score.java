package com.hashcode.service;

import com.hashcode.model.Photo;
import com.hashcode.model.Slide;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Score {


    public static Long getScore(Slide slide1, Slide slide2) {

        Set<String> tagsSlide1 = new HashSet<>();
        Set<String> tagsSlide2 = new HashSet<>();

        List<Photo> photos = slide1.getAllphotos();
        for (Photo photo : photos) {
            tagsSlide1.addAll(photo.getTags());
        }

        List<Photo> secondPhotos = slide2.getAllphotos();
        for (Photo photo : photos) {
            tagsSlide2.addAll(photo.getTags());
        }

        int A = 0;
        int B = 0;

        for (String string : tagsSlide1) {


            if (tagsSlide2.contains(string)) {
                B++;
            } else {
                A++;
            }

        }
        int size = tagsSlide2.size();

        int C = size - B;
        Long score = new Long(Math.min(A, Math.min(B, C)));
        return score;
    }
}
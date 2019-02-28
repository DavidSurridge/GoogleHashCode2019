package com.hashcode.service;

import com.hashcode.model.Photo;
import com.hashcode.model.Slide;
import com.hashcode.model.SlideShow;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class ExportSolution {

    private static String FILENAME = "output_e.txt";

    public static void export(SlideShow slideShow, String filename) {
        FILENAME = filename;
        List<String> results = new ArrayList<>();

        results.add(Integer.toString(slideShow.getSlides().size()));
        List<Slide> allSlides = slideShow.getSlides();

        for (Slide slide : allSlides) {
            List<Photo> photos = slide.getAllphotos();
            List<String> photosAdded = new ArrayList<>();
            for (Photo photo : photos
                    ) {
                photosAdded.add(photo.getId().toString());
            }
            results.add(photosAdded.toString());
        }
        System.out.println(results);


        File file = new File(FILENAME);

        try (FileWriter fw = new FileWriter(file.getAbsoluteFile(), true); BufferedWriter bw = new BufferedWriter(fw)) {
            StringBuilder data = new StringBuilder();
            for (String string : results) {
             string = string.replace("[","");
                string = string.replace("]","");
                string = string.replace(",","");
                data.append(string + "\n");
            }
            bw.write(data.toString().trim());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

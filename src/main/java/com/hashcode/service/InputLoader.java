package com.hashcode.service;

import com.hashcode.model.Photo;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InputLoader {

    private static final String INPUT_FILENAME = "a_example.txt";

    public InputLoader() {
        final File file = loadFileFromResources();
        parseFileContentToPayload(file);
    }

    private File loadFileFromResources() {
        final ClassLoader classLoader = getClass().getClassLoader();
        final String fileName = classLoader.getResource(INPUT_FILENAME).getFile();

        if (fileName == null) {
            throw new RuntimeException("Could not load the file from the resources folder.");
        }

        return new File(fileName);
    }

    private void parseFileContentToPayload(File file) {
        try {
            final List<String> content = FileUtils.readLines(file);
            final List<Photo> listOfPhotos = new LinkedList<>();

            content.remove(0);

            content.forEach(line -> {
                List<String> lineValues = Arrays.asList(line.split(" "));
                String orientation = lineValues.get(0);
                Integer numberOfTags = Integer.parseInt(lineValues.get(1));

                List<String> strings = lineValues.subList(2, lineValues.size());

                Photo photo = Photo.builder()
                        .orientation(orientation)
                        .numberOfTags(numberOfTags)
                        .tags(strings)
                        .build();

                listOfPhotos.add(photo);
            });

            System.out.println(listOfPhotos);

        } catch (IOException e) {
            throw new RuntimeException("The file cannot be read due to invalid characters.");
        }
    }

}

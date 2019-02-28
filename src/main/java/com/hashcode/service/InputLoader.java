package com.hashcode.service;

import com.hashcode.model.Payload;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class InputLoader {

    private static final String INPUT_FILENAME = "ExampleInput";

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
            content.forEach(System.out::println);
            //int[] Types = Arrays.asList(myData).stream().mapToInt(Integer::parseInt).toArray();
            //ArrayList<String> identifiers = new ArrayList<String>(List.of(line.split(" ")));
        } catch (IOException e) {
            throw new RuntimeException("The file cannot be read due to invalid characters.");
        }
    }

    public Payload getPayload() {
        return Payload.builder().attribute1("Testing Project Lombok").build();
    }
}

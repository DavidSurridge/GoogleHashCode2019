package PlayCode.controller;

import PlayCode.constants.InputValues;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        try {
            InputValues values = new InputValues("src/main/java/PlayCode/constants/ExampleInput");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

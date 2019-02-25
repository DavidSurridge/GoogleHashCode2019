package PlayCode.controller;

import java.io.IOException;

import PlayCode.constants.InputValues;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      
      try {
        InputValues values = new InputValues("src/main/java/PlayCode/constants/ExampleInput");
      } catch (IOException e) {
       
        e.printStackTrace();
      }
    }
}

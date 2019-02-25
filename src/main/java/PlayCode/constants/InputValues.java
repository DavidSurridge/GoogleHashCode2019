package PlayCode.constants;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputValues {

  public InputValues(String input) throws FileNotFoundException, IOException {

    File file = new File(input);
    System.out.println(file.getAbsolutePath());

    try (FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);) {

      // parse first line of the file
      String line = bufferedReader.readLine();

      String[] myData = line.split(" ");
      while (line != null) {

        myData = line.split(" ");
        
        
        //int[] Types = Arrays.asList(myData).stream().mapToInt(Integer::parseInt).toArray();
        //ArrayList<String> identifiers = new ArrayList<String>(List.of(line.split(" ")));

        System.out.println(line);
        line = bufferedReader.readLine();

      }
    }
  }
}

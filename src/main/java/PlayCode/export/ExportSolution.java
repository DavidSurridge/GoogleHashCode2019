package PlayCode.export;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportSolution {

  public ExportSolution() {
    // TODO Auto-generated constructor stub
  }

  public static void export(List<String> results) {
    String FILENAME = "output_e.txt";
    File file = new File(FILENAME);

    try (FileWriter fw = new FileWriter(file.getAbsoluteFile(), true); BufferedWriter bw = new BufferedWriter(fw);) {

      StringBuilder data = new StringBuilder();
      for (String string : results) {
        data.append(string + "\n");
      }

      bw.write(data.toString().trim());

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

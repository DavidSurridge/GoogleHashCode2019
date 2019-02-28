package PlayCode.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public final class ExportSolution {

    private static final String FILENAME = "output_e.txt";

    public static void export(List<String> results) {
        File file = new File(FILENAME);

        try (FileWriter fw = new FileWriter(file.getAbsoluteFile(), true); BufferedWriter bw = new BufferedWriter(fw)) {
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

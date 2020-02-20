package root.FileHandling;

import java.io.PrintWriter;
import java.util.List;

public class FileWriter {
    private static final String ENCODING = "UTF-8";

    public static void writeStrings(List<String> strings) {
        String filePath = FilePath.OUTPUT_PATH;

        try {
            PrintWriter writer = new PrintWriter(filePath, ENCODING);

            //System.out.println(strings.size());
            //writer.println(strings.size());

            for (String string : strings) {
                //System.out.println(string);
                writer.println(string);
            }

            writer.close();
        } catch (Exception e) {
            System.err.println("Exception occurred trying to write " + filePath);
            e.printStackTrace();
        }
    }
}

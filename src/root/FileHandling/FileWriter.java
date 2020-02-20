package root.FileHandling;

import root.Library;

import java.io.PrintWriter;
import java.util.List;

public class FileWriter {
    private static final String ENCODING = "UTF-8";


    public static void writeStrings(List<Library> libraries) {
        String filePath = FilePath.OUTPUT_PATH;

        try {
            PrintWriter writer = new PrintWriter(filePath, ENCODING);

            printLibraryCount(writer, libraries);


            //System.out.println(strings.size());
            //writer.println(strings.size());

            for (Library library : libraries) {
                //System.out.println(string);
                writer.println();
            }

            writer.close();
        } catch (Exception e) {
            System.err.println("Exception occurred trying to write " + filePath);
            e.printStackTrace();
        }
    }


    public static void printLibraryCount(PrintWriter writer, List<Library> libraries) {
        writer.println(libraries.size());
    }

    public static void printLibraryDescription(PrintWriter writer, Library library){
        writer.println(library.books.size());
    }


}

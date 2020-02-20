package root.FileHandling;

import root.Book;
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

            for (Library library : libraries) {
                printLibraryDescription(writer, library);
                printLibraryBooks(writer,library);
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

    public static void printLibraryDescription(PrintWriter writer, Library library) {
        writer.println(library.id + " " + library.books.size());
    }

    public static void printLibraryBooks(PrintWriter writer, Library library) {
        String res = "";

        for (Book book : library.books) {
            res += book.id + " ";
        }

        writer.println(res);
    }


}

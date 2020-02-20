package root;

import root.FileHandling.FileReader;
import root.FileHandling.FileWriter;
import root.FileHandling.InputDTO;

import java.util.Collections;
import java.util.List;

public class Main {
    public static int NUMBER_DAYS;

    public static void main(String[] args) {
        InputDTO input = FileReader.readInputFile();
        NUMBER_DAYS = input.numberDays;

        List<Library> libraries = findSolution(input.libraries);

        FileWriter.writeStrings(libraries);

        Validator.validate(libraries);
    }

    public static List<Library> findSolution(List<Library> libraries) {
        Collections.sort(libraries);

        for (Library library : libraries) {
            Collections.sort(library.books);
        }

        return libraries;
    }
}

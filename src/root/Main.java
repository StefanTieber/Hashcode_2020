package root;

import root.FileHandling.FileReader;
import root.FileHandling.FileWriter;
import root.FileHandling.InputDTO;

import java.util.List;

public class Main {
    public static int NUMBER_DAYS;

    public static void main(String[] args) {
        InputDTO input = FileReader.readInput();
        NUMBER_DAYS = input.numberDays;

        List<Library> libraries = findSolution(input.libraries);

        FileWriter.writeStrings(libraries);

        Validator.validate(libraries);
    }

    public static List<Library> findSolution(List<Library> libraries) {
        //sort by books per day
        //sort books by score

        return libraries;
    }
}

package root;

import root.FileHandling.FileReader;
import root.FileHandling.FileWriter;
import root.FileHandling.InputDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static int NUMBER_DAYS;
    public static List<Book> allBooks;

    public static void main(String[] args) {
        InputDTO input = FileReader.readInputFile();
        NUMBER_DAYS = input.numberDays;
        allBooks = input.books;
        Collections.sort(allBooks);

        List<Library> libraries = findSolution(input.libraries);

        FileWriter.writeStrings(libraries);

        Validator.validate(libraries);
    }

    public static List<Library> findSolution(List<Library> libraries) {
        List<Library> bestLibraries = new ArrayList<>();

        int day = 0;

        while(day<NUMBER_DAYS) {

            int maxScore = 0;
            Library bestLibrary = null;

            for (Library library : libraries) {
                int score = library.getScore(day);
                if (score > maxScore) {
                    maxScore = score;
                    bestLibrary = library;
                }
            }

            bestLibraries.add(bestLibrary);
            //remove best library
            day+=bestLibrary.timeForSignup;
        }

        //sort books of libraries

        return bestLibraries;
    }

    public void removeAllBooksScannedByThisLibrary(List<Book> books, Library library, int day) {
        int daysLeftToScan = NUMBER_DAYS - day;
        int numberOfScannableBooks = daysLeftToScan * library.booksPerDay;

        if (numberOfScannableBooks > books.size() - 1) {
            numberOfScannableBooks = books.size() - 1;
        }

        List<Book> scannableBooks = books.subList(0, numberOfScannableBooks);

        books.removeAll(scannableBooks);
    }
}

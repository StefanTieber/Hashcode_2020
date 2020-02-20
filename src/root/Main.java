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

        while (day < NUMBER_DAYS && libraries.size() > 0) {

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
            Library finalBestLibrary = bestLibrary;
            libraries.removeIf(obj -> obj.id == finalBestLibrary.id);
            removeAllBooksScannedByThisLibrary(bestLibrary.getBooksThatWillBeScanned(day - bestLibrary.timeForSignup), bestLibrary, day);
            day += bestLibrary.timeForSignup;
        }

        return bestLibraries;
    }

    public static void removeAllBooksScannedByThisLibrary(List<Book> books, Library library, int day) {
        int remainingDays = NUMBER_DAYS - (day + library.timeForSignup);

        if (remainingDays <= 0) {
            return;
        }

        int numberOfScannableBooks = remainingDays * library.booksPerDay;

        List<Book> scannableBooks;

        if (numberOfScannableBooks < books.size()) {
            scannableBooks = books.subList(0, numberOfScannableBooks);
        } else {
            scannableBooks = books;
        }

        books.removeAll(scannableBooks);
    }
}

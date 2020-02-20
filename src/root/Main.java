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
            System.out.println("Librarys: " + libraries.size());
            System.out.println("Days: " + day + " of " + NUMBER_DAYS);

            int maxScore = 0;
            Library bestLibrary = null;

            int i = 0;

            for (i = 0; i < Math.sqrt(libraries.size()); i++) {
                Library library = libraries.get(i);

                int score = library.getScore(day);
                if (score > maxScore) {
                    maxScore = score;
                    bestLibrary = library;
                }
            }

            for (; i < libraries.size(); i++) {
                Library library = libraries.get(i);

                int score = library.getScore(day);
                if (score > maxScore) {
                    maxScore = score;
                    bestLibrary = library;
                    break;
                }
            }

            bestLibraries.add(bestLibrary);
            Library finalBestLibrary = bestLibrary;
            libraries.removeIf(obj -> obj.id == finalBestLibrary.id);
            bestLibrary.relevantBooks = bestLibrary.getRelevantBooksForDays(day - bestLibrary.timeForSignup);
            removeAllBooksScannedByThisLibrary(bestLibrary.getRelevantBooksForDays(day - bestLibrary.timeForSignup), bestLibrary, day);

            for (Library library : libraries) {
                library.books.remove(bestLibrary.relevantBooks);
            }

            day += bestLibrary.timeForSignup;
        }

        return bestLibraries;
    }

    public static void removeAllBooksScannedByThisLibrary(List<Book> books, Library library, int day) {
        int remainingDays = NUMBER_DAYS - (day + library.timeForSignup);

        if (remainingDays <= 0) {
            return;
        }

        long numberOfScannableBooks = (long) remainingDays * (long) library.booksPerDay;

        List<Book> relevantBooks;

        if (numberOfScannableBooks < books.size()) {
            relevantBooks = books.subList(0, (int) numberOfScannableBooks);
        } else {
            relevantBooks = books;
        }

        allBooks.removeAll(relevantBooks);
    }
}

package root;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library implements Comparable {
    public int id;
    public int numberBooks;
    public int timeForSignup;
    public int booksPerDay;
    public List<Book> books = new ArrayList<>();


    @Override
    public int compareTo(Object o) {
        Library library = (Library) o;
        return Float.compare(this.pointsPerDay(), library.pointsPerDay());
    }

    public float pointsPerDay() {
        Collections.sort(books);

        int daysToScan = Main.NUMBER_DAYS - timeForSignup;
        int numberOfBooks = daysToScan * booksPerDay;

        if (numberOfBooks > books.size() - 1) {
            numberOfBooks = books.size() - 1;
        }

        List<Book> scannableBooks = books.subList(0, numberOfBooks);

        int score = getScore(scannableBooks);

        return (float) score / daysToScan;
    }

    private int getScore(List<Book> scannableBooks) {
        int score = 0;

        for (Book book : scannableBooks) {
            score += book.score;
        }

        return score;
    }
}

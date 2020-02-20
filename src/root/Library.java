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

        List<Book> scannableBooks = new ArrayList<>();

        if (daysToScan > 0) {
            long numberOfBooks = (long)daysToScan * (long)booksPerDay;

            if (numberOfBooks < books.size()) {
                scannableBooks = books.subList(0, (int)numberOfBooks);
            } else {
                scannableBooks = books;
            }
        }

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

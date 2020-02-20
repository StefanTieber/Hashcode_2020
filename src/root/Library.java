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

    public int getScore(int day) {
        int remainingDays = Main.NUMBER_DAYS - (day + timeForSignup);

        if (remainingDays <= 0) {
            return 0;
        }

        long numberOfBooks = (long) remainingDays * (long) booksPerDay;

        List<Book> relevantBooks = new ArrayList<>(books);

        for (int i = relevantBooks.size() - 1; i >= 0; i--) {
            Book book = relevantBooks.get(i);
            if (!Main.allBooks.contains(book)) {
                relevantBooks.remove(book);
            }
        }

        if (numberOfBooks < relevantBooks.size()) {
            relevantBooks = relevantBooks.subList(0, (int) numberOfBooks);
        }

        return getScoreofBookList(relevantBooks);
    }

    public float pointsPerDay() {
        Collections.sort(books);

        int daysToScan = Main.NUMBER_DAYS - timeForSignup;

        List<Book> scannableBooks = getBooksThatWillBeScanned(daysToScan);

        int score = getScoreofBookList(scannableBooks);

        return (float) score / daysToScan;
    }

    private int getScoreofBookList(List<Book> scannableBooks) {
        int score = 0;

        for (Book book : scannableBooks) {
            score += book.score;
        }

        return score;
    }

    public List<Book> getBooksThatWillBeScanned(int daysToScan) {
        List<Book> scannableBooks = new ArrayList<>();

        if (daysToScan > 0) {
            long numberOfBooks = (long) daysToScan * (long) booksPerDay;

            if (numberOfBooks < books.size()) {
                scannableBooks = books.subList(0, (int) numberOfBooks);
            } else {
                scannableBooks = books;
            }
        }

        return scannableBooks;
    }
}

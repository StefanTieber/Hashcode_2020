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
    public List<Book> relevantBooks = new ArrayList<>();


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

        return getScoreofBookList(books);
    }

    public List<Book> getRelevantBooksForDays(long remainingDays) {
        List<Book> relevantBooks = getRelevantBooks();

        if (remainingDays > 0) {
            long numberOfBooks = remainingDays * (long) booksPerDay;

            if (numberOfBooks < books.size()) {
                relevantBooks = books.subList(0, (int) numberOfBooks);
            } else {
                relevantBooks = books;
            }
        }

        return relevantBooks;
    }

    private List<Book> getRelevantBooks() {
        List<Book> relevantBooks = new ArrayList<>(books);

        for (int i = relevantBooks.size() - 1; i >= 0; i--) {
            Book book = relevantBooks.get(i);
            if (!Main.allBooks.contains(book)) {
                relevantBooks.remove(book);
            }
        }
        return relevantBooks;
    }

    public float pointsPerDay() {
        Collections.sort(books);

        int daysToScan = Main.NUMBER_DAYS - timeForSignup;

        List<Book> scannableBooks = getRelevantBooksForDays(daysToScan);

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
}

package root;

import java.util.ArrayList;
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
        return Integer.compare(this.booksPerDay, library.booksPerDay);
    }
}

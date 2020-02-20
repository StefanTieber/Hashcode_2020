package root;

public class Book implements Comparable {
    public Integer id;
    public Integer score;

    public Book(Integer id, Integer score) {
        this.id = id;
        this.score = score;
    }

    @Override
    public int compareTo(Object o) {
        Book book = (Book) o;
        return Integer.compare(this.score, book.score);
    }
}

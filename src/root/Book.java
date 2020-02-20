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
        return Integer.compare(book.score, this.score);
    }

    @Override
    public boolean equals(Object o) {
        return ((Book) o).id.equals(id);
    }
}

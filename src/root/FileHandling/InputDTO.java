package root.FileHandling;

import root.Book;
import root.Library;

import java.util.ArrayList;
import java.util.List;

public class InputDTO {
    public int numberBooks;
    public int numberLibraries;
    public int numberDays;
    public List<Book> books = new ArrayList<>();
    public List<Library> libraries = new ArrayList<>();
}

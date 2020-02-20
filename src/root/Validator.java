package root;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validator {
    public static void validate(List<Library> libraries) {
        List<Book> books = new ArrayList<>();
        int days = 0;

        for (Library library : libraries) {
            days += library.timeForSignup;

            int daysActive = Main.NUMBER_DAYS - days;

            if (daysActive > 0) {
                int booksScanned = daysActive * library.booksPerDay;

                books.addAll(library.books.subList(0, booksScanned));
            }
        }

        Collection<Book> nonDuplicatedEmployees = books.stream()
                .<Map<Integer, Book>>collect(HashMap::new, (m, e) -> m.put(e.id, e), Map::putAll)
                .values();

        int score = 0;

        for (Book book : nonDuplicatedEmployees) {
            score += book.score;
        }

        System.out.println("SCORE: " + score);
    }
}

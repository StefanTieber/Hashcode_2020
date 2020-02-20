package root.FileHandling;

import root.Book;
import root.Library;

import java.io.BufferedReader;
import java.util.Collections;

public class FileReader {
    public static InputDTO readInputFile() {
        String filePath = FilePath.INPUT_PATH;

        InputDTO inputDTO = new InputDTO();

        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath));

            String line;
            String[] parts;

            line = reader.readLine();
            parts = line.split("\\s+");
            inputDTO.numberBooks = Integer.parseInt(parts[0]);
            inputDTO.numberLibraries = Integer.parseInt(parts[1]);
            inputDTO.numberDays = Integer.parseInt(parts[2]);

            line = reader.readLine();
            parts = line.split("\\s+");

            for (int i = 0; i < inputDTO.numberBooks; i++) {
                int score = Integer.parseInt(parts[i]);
                inputDTO.books.add(new Book(i, score));
            }

            for (int i = 0; i < inputDTO.numberLibraries; i++) {
                Library library = new Library();
                library.id = i;

                line = reader.readLine();
                parts = line.split("\\s+");

                library.numberBooks = Integer.parseInt(parts[0]);
                library.timeForSignup = Integer.parseInt(parts[1]);
                library.booksPerDay = Integer.parseInt(parts[2]);

                line = reader.readLine();
                parts = line.split("\\s+");

                for (int j = 0; j < library.numberBooks; j++) {
                    int id = Integer.parseInt(parts[j]);
                    library.books.add(inputDTO.books.get(id));
                }

                Collections.sort(library.books);

                inputDTO.libraries.add(library);
            }

            reader.close();

            return inputDTO;
        } catch (Exception e) {
            System.err.println("Exception occurred trying to read " + filePath);
            e.printStackTrace();
            return null;
        }
    }
}

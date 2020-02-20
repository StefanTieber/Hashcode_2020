package root.FileHandling;

import root.Matrix;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public static List<String> readStrings() {
        String filePath = FilePath.INPUT_PATH;

        List<String> strings = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath));

            String line = reader.readLine();
            String[] parts = line.split("\\s+");
            int numberOfRows = Integer.parseInt(parts[0]);

            for (int i = 0; i < numberOfRows; i++) {
                line = reader.readLine();
                //System.out.println(line);
                strings.add(line);
            }

            reader.close();

            return strings;
        } catch (Exception e) {
            System.err.println("Exception occurred trying to read " + filePath);
            e.printStackTrace();
            return null;
        }
    }

    public static Matrix readMatrixFile() {
        String filePath = FilePath.INPUT_PATH;

        Matrix matrix = new Matrix();

        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath));

            matrix = readMatrix(reader);

            reader.close();
        } catch (Exception e) {
            System.err.println("Exception occurred trying to read " + filePath);
            e.printStackTrace();
        }

        return matrix;
    }

    private static Matrix readMatrix(BufferedReader reader) {
        Matrix matrix = new Matrix();

        String line;
        String[] parts;

        try {
            line = reader.readLine();
            parts = line.split("\\s+");

            matrix.y = Integer.parseInt(parts[0]);
            matrix.x = Integer.parseInt(parts[1]);
            matrix.values = new int[matrix.y][matrix.x];

            for (int iY = 0; iY < matrix.y; iY++) {
                line = reader.readLine();
                parts = line.split("\\s+");

                for (int iX = 0; iX < matrix.x; iX++) {
                    matrix.values[iY][iX] = Integer.parseInt(parts[iX]);
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("First line is not a number!");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Exception occurred while reading file!");
            e.printStackTrace();
        }

        return matrix;
    }
}

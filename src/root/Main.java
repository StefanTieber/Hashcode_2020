package root;

import root.FileHandling.FileReader;
import root.FileHandling.FileWriter;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("test commit");

        List<String> strings = FileReader.readStrings();

        FileWriter.writeStrings(strings);
    }
}

package root;

import root.FileHandling.FileReader;
import root.FileHandling.FileWriter;
import root.FileHandling.InputDTO;

import java.util.ArrayList;
import java.util.List;

public class Main {


    static List<Library> example = new ArrayList<>();


    public static void main(String[] args) {
        InputDTO inputDTO = FileReader.readInputFile();



        example.add(new Library());


//        List<String> strings = FileReader.readStrings();
//
        FileWriter.writeStrings(example);

//        Validator.validate(strings);






    }
}

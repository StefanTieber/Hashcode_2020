package root;

import root.FileHandling.FileReader;
import root.FileHandling.FileWriter;

import java.util.ArrayList;
import java.util.List;

public class Main {


    static List<Library> example = new ArrayList<>();


    public static void main(String[] args) {
        Book b1 = new Book();
        b1.id=1;
        Book b2 = new Book();
        b2.id=2;
        Book b3 = new Book();
        b3.id=3;



        example.add(new Library());


//        List<String> strings = FileReader.readStrings();
//
        FileWriter.writeStrings(example);

//        Validator.validate(strings);






    }
}

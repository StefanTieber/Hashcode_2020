package root.FileHandling;

public class FilePath {
    private static final String RESOURCE_PATH = "src\\resources\\";

    private static final String FILE_NAME = "test";
//    private static final String FILE_NAME = "a_example";
//    private static final String FILE_NAME = "b_small";
//    private static final String FILE_NAME = "c_medium";
//    private static final String FILE_NAME = "d_quite_big";
//    private static final String FILE_NAME = "e_also_big";

    private static final String INPUT_FILE_EXTENSION = ".in";
    private static final String OUTPUT_FILE_EXTENSION = ".out";

    private static final String INPUT_RESOURCE_PATH = RESOURCE_PATH + "inputs\\";
    private static final String OUTPUT_RESOURCE_PATH = RESOURCE_PATH + "outputs\\";

    public static final String INPUT_PATH = INPUT_RESOURCE_PATH + FILE_NAME + INPUT_FILE_EXTENSION;
    public static final String OUTPUT_PATH = OUTPUT_RESOURCE_PATH + FILE_NAME + OUTPUT_FILE_EXTENSION;
}

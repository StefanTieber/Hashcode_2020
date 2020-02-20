package root.FileHandling;

class FilePath {
    private static String DIRECTORY = "C:\\Users\\Steve\\Documents\\_Documents\\ccc\\ccc2019_2\\";
    private static String RESOURCE_DIR = "resource\\";

    private static String LEVEL = "level1";
    //private static String LEVEL = "level2";
    //private static String LEVEL = "level3";
    //private static String LEVEL = "level4";
    //private static String LEVEL = "level5";
    //private static String LEVEL = "level6";
    //private static String LEVEL = "level7";
    //private static String LEVEL = "level8";

    private static String FILE_NUMBER = "1";
    //private static String FILE_NUMBER = "2";
    //private static String FILE_NUMBER = "3";
    //private static String FILE_NUMBER = "4";
    //private static String FILE_NUMBER = "5";

    private static String RESOURCE_EXT = ".resource";
    private static String INPUT_EXT = ".in";
    private static String OUTPUT_EXT = ".out";

    private static String FILE_PATH = LEVEL + "\\" + LEVEL + "_" + FILE_NUMBER;

    static String RESOURCE_PATH = RESOURCE_DIR + LEVEL + "_" + FILE_NUMBER + RESOURCE_EXT;
    static String INPUT_PATH = DIRECTORY + FILE_PATH + INPUT_EXT;
    static String OUTPUT_PATH = DIRECTORY + FILE_PATH + OUTPUT_EXT;
}

package sample.Model;

public class CurrentDictionary {
    private static  String currentDictionaryName;

    public static void assignDictionaryName(String dictionaryName) {
        currentDictionaryName = dictionaryName;
    }

    public static String getCurrentDictionaryName() {
        return currentDictionaryName;
    }
}

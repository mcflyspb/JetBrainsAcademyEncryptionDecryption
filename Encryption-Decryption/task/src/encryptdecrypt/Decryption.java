package encryptdecrypt;

public class Decryption {

    public static char[] run(String message, int key, String alg) {
        switch (alg) {
            case "unicode" -> {
                return decodeUnicodeAlg(message, key);
            }
            case "shift" -> {
                if (key > 0) {
                    return decodeShiftAlgWithKey(message, key);
                }
                return ShiftAlg.run(message);
            }
        }
        return null;
    }

    private static char[] decodeShiftAlgWithKey(String message, int key) {
        char[] currectChar = message.toCharArray();
        for (int x = 0; x < currectChar.length; x++) {
            if (currectChar[x] > 64 && currectChar[x] < 91) {
                currectChar[x] = (char) ((currectChar[x] - key - 'A' + 26) % 26 + 'A');
            }

            if (currectChar[x] > 96 && currectChar[x] < 123) {
                currectChar[x] = (char) ((currectChar[x] - key - 'a' + 26) % 26 + 'a');
            }
        }
        return currectChar;
    }

    public static char[] decodeUnicodeAlg(String message, int key) {
        char[] lineFromConsoleArray = message.toCharArray();
        for (int x = 0; x < lineFromConsoleArray.length; x++) {
            lineFromConsoleArray[x] = (char) (lineFromConsoleArray[x] - key);
        }
        return lineFromConsoleArray;
    }
}

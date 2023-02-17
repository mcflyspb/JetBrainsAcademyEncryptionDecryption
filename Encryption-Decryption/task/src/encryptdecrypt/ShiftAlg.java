package encryptdecrypt;

public class ShiftAlg {
    public static char[] run(String message) {
        char[] currectChar = message.toCharArray();
        for (int x = 0; x < currectChar.length; x++) {
            if ((currectChar[x] > 64 && currectChar[x]  < 91)) {
                currectChar[x]  = (char) (155 - currectChar[x]);
            } else if ((currectChar[x]  > 96 && currectChar[x]  < 123)) {
                currectChar[x]  = (char) (219 - currectChar[x] );
            }
        }
        return currectChar;
    }
}

package encryptdecrypt;

import java.io.*;


public class FileOperation {

    public static String readMessageFromFile(String inFile) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(inFile))) {
            return br.readLine();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static void writeResultToFile(char[] result, String outFile) throws Exception {
        try (PrintWriter writer = new PrintWriter(outFile, "UTF-8")) {
            writer.print(result);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}

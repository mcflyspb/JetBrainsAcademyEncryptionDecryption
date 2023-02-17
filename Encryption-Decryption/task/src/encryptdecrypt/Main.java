package encryptdecrypt;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String mode = "enc";
        String alg = "shift";
        int key = 0;
        String message = "";
        String inFile = "";
        String outFile = "";
        char[] result = {'0'};

        for (int x = 0; x < args.length; x += 2) {
            if (Objects.equals(args[x],"-key")) {
                key = Integer.parseInt(args[x + 1]);
            }
            if (Objects.equals(args[x],"-mode")) {
                mode = args[x + 1];
            }
            if (Objects.equals(args[x],"-data")) {
                message = args[x + 1];
            }
            if (Objects.equals(args[x],"-in")) {
                inFile = args[x + 1];
            }
            if (Objects.equals(args[x],"-out")) {
                outFile = args[x + 1];
            }
            if (Objects.equals(args[x],"-alg")) {
                alg = args[x + 1];
            }

        }

        if (message.length() == 0 && inFile.length() > 0) {
            message = FileOperation.readMessageFromFile(inFile);
        }

        System.out.println(message);

        switch (mode) {
            case "enc" -> {
                result = Encryption.run(message, key, alg);
            }
            case "dec" -> {
                result = Decryption.run(message, key, alg);
            }
        }

        if (outFile.length() > 0) {
            FileOperation.writeResultToFile(result,outFile);
        } else {
            System.out.println(result);
        }
        System.out.println(result);
    }
}


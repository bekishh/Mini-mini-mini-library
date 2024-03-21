package tools;

import java.util.Random;

public class GenerateISBN {
    public static String generateBookISBN() {
        return String.valueOf(String.valueOf(Math.abs(new Random().nextInt(1, 1000))).hashCode());
    }
}

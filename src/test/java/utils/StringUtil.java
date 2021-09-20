package utils;

import java.util.Random;

public class StringUtil {
    private static Random random = new Random();
    private static final String CHAR_ABC = "abcdefghijklmnopqrstuvwxyz";//из этих символов будем формировать случайную строку

    public static String generateRandomString(int stringlenght) {
        StringBuilder stringBuilder = new StringBuilder(stringlenght);
        for (int i = 0; i < stringlenght; i++) {
            stringBuilder.append(CHAR_ABC.charAt(random.nextInt(CHAR_ABC.length())));//добавляем по одному случайному висволу
        }
        return stringBuilder.toString();
    }
}

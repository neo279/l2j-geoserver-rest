package com.l2jserver.gameserver.util;

public class Util {
    /**
     * @param text - the text to check
     * @return {@code true} if {@code text} contains only numbers, {@code false} otherwise
     */
    public static boolean isDigit(String text) {
        if ((text == null) || text.isEmpty()) {
            return false;
        }
        for (char c : text.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}

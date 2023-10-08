package de.ait.homeworks34;

public class StringProcessor {

        public String concatenate(String str1, String str2) {
            return str1 + str2;
        }

        public int getLength(String str) {
            return str.length();
        }

        public String reverse(String str) {
            return new StringBuilder(str).reverse().toString();
        }

        public String reversePlus(String str) {
        if (str == null) {
            return null; // Обработка случая, когда строка равна null
        }
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
        }

        public boolean isPalindrome(String str) {
            String reversed = reverse(str);
            return str.equals(reversed);
        }
        public boolean isPalindromePlus(String str) {
        if (str == null) {
            return false;
        }

        str = str.toLowerCase();

        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
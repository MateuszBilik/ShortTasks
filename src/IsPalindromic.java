public class IsPalindromic {
    public static String StringChallenge(String str) {
        int length = str.length();

        boolean isPalindromic = isPalindromic(str);
        if (isPalindromic) {
            return str;
        }

        for (int i = 0; i < length; i++) {
            String remove = String.valueOf(str.charAt(i));
            String newStr = str.replaceFirst(remove, "");

            if (isPalindromic(newStr) & newStr.length() > 2) {
                return remove;
            }
        }

        for (int i = 0; i < length - 1; i++) {
            String remove = String.valueOf(str.charAt(i))
                    + String.valueOf(str.charAt(i + 1));
            String newStr = str.replaceFirst(remove, "");

            if (isPalindromic(newStr) & newStr.length() > 2) {
                return remove;
            }
        }

        return "not possible";
    }

    private static boolean isPalindromic(String str) {
        int length = str.length();
        boolean isPalindromic = true;

        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                isPalindromic = false;
            }
        }
        return isPalindromic;
    }
}

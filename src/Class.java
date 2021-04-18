public class Class {


    public static String TheSame(String str) {
        String returnStr = "";

        for(int i = 0; i < str.length(); i++){
            char letter = str.charAt(i);
            int theSame = 1;

            for(int j = i + 1; j < str.length(); j++){
                if (letter == str.charAt(j)){
                    theSame++;
                } else {
                    i = j - 1;
                    returnStr = returnStr + theSame + letter;
                    break;
                }
            }
            if (i == str.length() - 1){
                returnStr = returnStr + theSame + letter;
            }
        }
        int length = str.length();
        extracted(str, length);

        return returnStr;

    }

    private static void extracted(String str, int length) {
        boolean isPalindromic = true;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                isPalindromic = false;
            }
        }
    }

}

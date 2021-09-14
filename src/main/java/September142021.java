import java.util.*;

/*
Java:
1) Write a program to encrypt a message using the ROT13 technique.
2) Write a program to convert a decimal number to its octal equivalent.
 */
public class September142021 {
    public static void main(String[] args) {
        //prints "nopklm"
        System.out.println(rot13("abcxyz"));
        //prints "uryyb"
        System.out.println(rot13("hello"));


        //prints 105457 (octal version of the decimal number)
        System.out.println(decimalOctal(35631));
        //prints 16612 (octal version of the decimal number)
        System.out.println(decimalOctal(7562));

    }

    /**
     * 1) Properly encrypts a given string to its ROT13 variant
     * @param str
     * @return String
     */
    public static String rot13(String str){
        StringBuilder result = new StringBuilder();
        String lowerCase = str.toLowerCase();
        for(int i = 0; i < lowerCase.length(); i++){
            char currChar = lowerCase.charAt(i);
            currChar += 13;
            if((int) currChar > 122){
                int diff = currChar - 122;
                currChar = (char) (96 + diff);
            }
            result.append(currChar);
        }
        return result.toString();
    }


    public static String decimalOctal(int val){
        StringBuilder result = new StringBuilder();
        while(val / 8 != 0){
            int remainder = val % 8;
            val = val /8;
            result.append(remainder);
        }
        result.append(val % 8);

        return result.reverse().toString();
    }
}

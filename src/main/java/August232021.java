import java.sql.*;
import java.util.*;

/*
Create a function that takes a number as an argument and returns true if the number is a valid credit card number,
false otherwise.

Credit card numbers must be between 14-19 digits in length, and pass the Luhn test, described below:

Remove the last digit (this is the "check digit").
Reverse the number.
Double the value of each digit in odd-numbered positions. If the doubled value has more than 1 digit, add the digits
together (e.g. 8 x 2 = 16 ➞ 1 + 6 = 7).

Add all digits.
Subtract the last digit of the sum (from step 4) from 10. The result should be equal to the check digit from step 1.
Examples
validateCard(1234567890123456) --> false

// Step 1: check digit = 6, num = 123456789012345
// Step 2: num reversed = 543210987654321
// Step 3: digit array after selective doubling: [1, 4, 6, 2, 2, 0, 9, 8, 5, 6, 1, 4, 6, 2, 2]
// Step 4: sum = 58
// Step 5: 10 - 8 = 2 (not equal to 6) --> false

validateCard(1234567890123452) --> true


 */
public class August232021 {
    public static void main(String[] args) {

        System.out.println(validateCard(1234567890123456L)); //false
        System.out.println(validateCard(1234567890123452L)); //true

    }

    public static boolean validateCard(long input){
        StringBuilder stringBuilder = new StringBuilder();
        String string = "" + input;
        int check = Integer.parseInt(string.substring(string.length()-1));
        string = string.substring(0, string.length()-1);
        stringBuilder.append(string);
        stringBuilder.reverse();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < stringBuilder.length(); i++){
            int curr = Integer.parseInt(stringBuilder.substring(i, i + 1));
            if((i+1) % 2 == 0){
                list.add(curr);
            }
            else{
                curr = curr * 2;
                String currString = "" + curr;
                if(currString.length() > 1){
                    list.add(Integer.parseInt(currString.substring(0, 1)) + Integer.parseInt(currString.substring(1,2)));
                }
                else{
                    list.add(Integer.valueOf(currString));
                }
            }
        }
        int sum = 0;
        for(Integer i: list){ sum += i; }
        String sumString = "" + sum;

        int checker = 10 - Integer.parseInt(sumString.substring(sumString.length()-1));
        if(checker == check) return true;
        return false;


    }
}

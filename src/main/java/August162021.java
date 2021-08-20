import java.util.*;

/*

Write a function that divides a phrase into word buckets, with each bucket containing n or fewer characters.
Only include full words inside each bucket.

Examples
bucketize("she sells sea shells by the sea", 10)
➞ ["she sells", "sea shells", "by the sea"]

bucketize("the mouse jumped over the cheese", 7)
➞ ["the", "mouse", "jumped", "over", "the", "cheese"]

bucketize("fairy dust coated the air", 20)
➞ ["fairy dust coated", "the air"]

bucketize("a b c d e", 2)
➞ ["a", "b", "c", "d", "e"]

Notes
Spaces count as one character.
Trim beginning and end spaces for each word bucket (see final example).
If buckets are too small to hold a single word, return an empty array: []
The final goal isn't to return just the words with a length equal (or lower) to the given n, but to return the entire
given phrase bucketized (if possible). So, for the specific case of "by" the only word with a proper length, the
phrase can't be bucketized, and the returned array has to be empty.
 */
public class August162021 {

    public static String[] bucketize(String str, int n){
        String[] strArr = str.split(" ");
        ArrayList<String> resultAL = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for(String curr: strArr){
            if(stringBuilder.length() + curr.length() <= n){
                stringBuilder.append(curr + " ");
            }
            else{
                resultAL.add(stringBuilder.toString().trim());
                stringBuilder.setLength(0);
                stringBuilder.append(curr + " ");
            }
        }
        resultAL.add(stringBuilder.toString().trim());
        return resultAL.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String test1 = "she sells sea shells by the sea";
        String test2 = "the mouse jumped over the cheese";
        String test3 = "fairy dust coated the air";
        String test4 = "a b c d e";

        String[] one = bucketize(test1, 10);
        String[] two = bucketize(test2, 7);
        String[] three = bucketize(test3, 20);
        String[] four = bucketize(test4, 2);

        print(one);
        print(two);
        print(three);
        print(four);

    }

    public static void print(String ... arr)
    {
        StringBuilder strb = new StringBuilder("[");
        for (String str:arr
             ) {
            strb.append(str + ", ");
        }
        System.out.println(strb.toString().substring(0,strb.length() - 2).concat("]"));
    }
}

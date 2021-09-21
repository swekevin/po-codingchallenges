/*
3) Java:

Create a function that takes the memory size (ms is a string type) as an argument and returns the actual memory size.

Examples
actualMemorySize("32GB") --> "29.76GB"

actualMemorySize("2GB") --> "1.86GB"

actualMemorySize("512MB") --> "476MB"

Notes
-The actual storage loss on a USB device is 7% of the overall memory size!
-If the actual memory size was greater than 1 GB, round your result to two decimal places.
-If the memory size after adjustment is smaller then 1 GB, return the result in MB.
 */

public class September202021 {
    public static void main(String[] args) {
        //Returns 476MB
        System.out.println(actualMemorySize("512MB"));
        //Returns 1.86GB
        System.out.println(actualMemorySize("2GB"));
        //Returns 29.76GB
        System.out.println(actualMemorySize("32GB"));
        //Returns 930MB
        System.out.println(actualMemorySize("1GB"));

    }

    public static String actualMemorySize(String ms){
        StringBuilder result = new StringBuilder();
        if(ms.endsWith("MB")){
            int actual = (int)(Integer.parseInt(ms.substring(0, ms.indexOf("MB"))) * 0.93);
            result.append(actual).append("MB");
        }
        else {
            double actual = Double.parseDouble(ms.substring(0, ms.indexOf("GB"))) * 0.93;
            if(actual < 1.0){
                int actualInt = (int) (actual * 1000);
                result.append(actualInt).append("MB");
            }
            else{
                result.append(String.format("%,.2f", actual)).append("GB");
            }

        }
        return result.toString();
    }

}

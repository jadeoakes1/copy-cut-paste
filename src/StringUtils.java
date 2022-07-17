/* Jade Oakes
   7/13/22
   This program contains methods to print a string with corresponding integers to
   track index positions, as well as methods for copy, cut, and paste
*/

public class StringUtils {
    /** Prints out the current string with character positions underneath it. (0 – 9) */
    // The code for this method was starter code
    public static void genGauge(String currentString) {
        System.out.println(currentString);
        int c = 0;
        int i = currentString.length();
        String gauge = "";
        while(c < i) {
            gauge = gauge + c;
            if (c < 9) {
                c++;
            }
            else {
                c = 0;
                i = i - 10;
            }
        }
        System.out.println(gauge);
    }

    /** Returns a substring from indices beginning with startPosition and ending with onePastLastPosition */
    public static String copy(String currentString, int startPosition, int onePastLastPosition) {
        return currentString.substring(startPosition, onePastLastPosition);
    }

    /** Returns a string without the values from indices at startPosition to onePastLastPosition */
    public static String cut(String currentString, int startPosition, int onePastLastPosition) {
        return currentString.substring(0, startPosition) + currentString.substring(onePastLastPosition);
    }

    /** Returns a string with stringToInsert inserted one before the index at insertBefore */
    public static String paste(String currentString, int insertBefore, String stringToInsert) {
        return currentString.substring(0, insertBefore) + stringToInsert + currentString.substring(insertBefore);
    }
}
/* Jade Oakes
   7/13/22
   This program contains the main method that allows users to perform copy, cut, and paste
   functions on a custom string
*/

import java.util.Scanner;

public class StringMangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Get string input from user
        System.out.println("Enter a string below:");
        String currentString = input.nextLine();
        // Display string and numbers 0-9 to find position of each character
        System.out.println("\nThe current string is:");
        StringUtils.genGauge(currentString);

        String clipboard = "";
        int startPosition;
        int onePastLastPosition;
        int insertBefore;

        String copy;
        String cut;

        // Get input for user's decision
        System.out.println("\nEnter c to copy, x to cut, v to paste, q to quit");
        String decision = input.next();
        // Loop until user enters q
        while (!decision.equalsIgnoreCase("q")) {
            if (decision.equalsIgnoreCase("c")) {
                // If user enters c, copy desired substring and add it to the clipboard
                System.out.print("Enter the starting position: ");
                startPosition = input.nextInt();
                System.out.print("Enter one past the ending position: ");
                onePastLastPosition = input.nextInt();
                copy = StringUtils.copy(currentString, startPosition, onePastLastPosition);

                // Add copied content to clipboard
                clipboard = copy;

            }
            else if (decision.equalsIgnoreCase("x")) {
                // If user enters x, remove desired substring from current string and add it to the clipboard
                System.out.print("Enter the starting position: ");
                startPosition = input.nextInt();
                System.out.print("Enter one past the ending position: ");
                onePastLastPosition = input.nextInt();
                cut = currentString.substring(startPosition, onePastLastPosition);
                clipboard = cut;
                currentString = StringUtils.cut(currentString, startPosition, onePastLastPosition);
                System.out.println("Test cut: " + currentString);
            }
            else if (decision.equalsIgnoreCase("v")) {
                // If user enters v, insert the desired substring into current string at desired index location
                System.out.print("Enter the position the paste should come before: ");
                insertBefore = input.nextInt();
                currentString = StringUtils.paste(currentString, insertBefore, clipboard);
            }

            // Display the current string and the clipboard contents
            System.out.println("\nThe current string is:");
            StringUtils.genGauge(currentString);
            System.out.println("The clipboard is " + clipboard + " and it has a length of " + clipboard.length());

            // Prompt user for new option
            System.out.println("\nEnter c to copy, x to cut, v to paste, q to quit");
            decision = input.next();
        }
    }
}
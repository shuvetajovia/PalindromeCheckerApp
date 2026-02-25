import java.util.*;

public class UseCase13PalindromeCheckerApp {

    // Method 1: String Reverse
    public static boolean reverseMethod(String input) {
        String rev = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            rev += input.charAt(i);
        }
        return input.equals(rev);
    }

    // Method 2: Stack
    public static boolean stackMethod(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // Method 3: Deque
    public static boolean dequeMethod(String input) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String input = "madamimadam";

        // Reverse Method Timing
        long start1 = System.nanoTime();
        boolean r1 = reverseMethod(input);
        long end1 = System.nanoTime();

        // Stack Method Timing
        long start2 = System.nanoTime();
        boolean r2 = stackMethod(input);
        long end2 = System.nanoTime();

        // Deque Method Timing
        long start3 = System.nanoTime();
        boolean r3 = dequeMethod(input);
        long end3 = System.nanoTime();

        System.out.println("Input: " + input);

        System.out.println("Reverse Method: " + r1 +
                " | Time: " + (end1 - start1) + " ns");

        System.out.println("Stack Method: " + r2 +
                " | Time: " + (end2 - start2) + " ns");

        System.out.println("Deque Method: " + r3 +
                " | Time: " + (end3 - start3) + " ns");
    }
}
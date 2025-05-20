package program_assignments_CS202;

import java.util.*;

public class program_assignment4 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter a mathematical expression: ");
        String expression = keyboard.nextLine();
        keyboard.close();
        Stack<Character> s = new Stack<Character>();

        boolean isBalanced = true;
        int mismatchPosition = 0;

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
             // if c is '(' or '{' or '[', then push c into s
            if (c == '(' || c == '{' || c == '[') {
                s.push(c);
                display(s);
            } else if (c == ')' || c == '}' || c == ']') {
                if (s.isEmpty()) {
                    isBalanced = false;
                    mismatchPosition = i + 1;
                    break;
                }

                char top = s.pop();
                if (!isMatching(top, c)) {
                    isBalanced = false;
                    mismatchPosition = i + 1;
                    break;
                }

                display(s);
            }
        }

        if (!s.isEmpty() && isBalanced) {
            isBalanced = false;
            mismatchPosition = expression.length();
        }

        if (isBalanced) {
            System.out.println("The input expression is balanced!");
        } else {
            System.out.println("The input expression is not balanced! The first mismatch is found at position " + mismatchPosition + "!");
        }
    }

    public static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }

    
    public static void display(Stack<Character> stack) {
        for (int i = 0; i < stack.size(); i++) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
    }
   
}



/*
*
* if operand, push to stack
*
* */

import java.util.*;

class ReversePolishNotation {

    public static boolean isOperator(String s) {
        return s.equals("/") || s.equals("*") || s.equals("+") || s.equals("-");
    }

    public static String evaluatePostFix(String[] tokens) {
        Stack<String> stack = new Stack<String>();

        for(String str : tokens) {
            if(!isOperator(str))
                stack.push(str);
            else {
                long a = Long.parseLong(stack.pop());
                long b = Long.parseLong(stack.pop());
                switch(str) {
                    case "/":
                        stack.push(String.valueOf(b/a));
                        break;
                    case "*":
                        stack.push(String.valueOf(b*a));
                        break;
                    case "+":
                        stack.push(String.valueOf(b+a));
                        break;
                    case "-":
                        stack.push(String.valueOf(b-a));
                        break;
                }
            }
        }

        return stack.pop();
    }

    public static void main(String args[]) {
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(evaluatePostFix(tokens));
    }
}
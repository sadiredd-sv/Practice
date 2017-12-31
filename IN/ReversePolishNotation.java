/*

1. Infix (harder):
https://www.geeksforgeeks.org/expression-evaluation/

2. Postfix (ReversePolishNotation):
https://www.programcreek.com/2012/12/leetcode-evaluate-reverse-polish-notation/



Infix expression evaluation: 2 stacks are needed to evaluate the operator precedence.

1. If value, put in value stack.
2. If left bracket, put in operator stack
3. If right bracket:
	3.1. Pick 2 values from value stack
	3.2. Pick 1 operator from operator stack. 
	3.3. Calculate and put the result in value stack
	3.4. Discard the left bracket
4. If operator:
	4.1. If the operator stack isnt empty, pop the operator from top of the stack if it has higher precedence.
	4.2. Pick the 2 values from value stack and apply this picked operator after 4.1. Place the result on value stack
	4.3. Put the current operator on the stack (2 cases: 1) If the operator on the top of operator stack has lower precedence  or   2) If the operator stack is empty. or 3) After 4.1 and 4.2 ) 
5. If the operator stack isnt empty, pick an operator from the top of stack along with 2 values from the value stack.
	5.1. Calculate and put the result in value stack.
	5.2. Repeat this until the stack is empty

*/

import java.util.*;

class ReversePolishNotation {

	Stack<Integer> values = new Stack<>();
	Stack<String> operators = new Stack<>();

	void evaluate(String expression) {

		String[] strArray = expression.split(" ");

		// All the strings in the original string are handled: Steps 1,2,3,4
		for(String str : strArray) {
			if(isOperator(str))
				handleCases(str);
			else
				values.push(Integer.parseInt(str));
		}
		// Step 5
		while(!operators.isEmpty())
			 popValuesCalculateAndPushToStack();

		System.out.println(values.peek());
	}

	boolean isOperator(String input) {

		String[] ops = {"*","/","+","-",")","("};
		for(String s : ops) {
			if(input.equals(s))
				return true;
		}
		return false;
	}

	void handleCases(String str) {

		switch(str) {
			case "(":
				operators.push(str);
				break;
			case "/":
			case "*":
			case "+":
			case "-":
				while(!operators.isEmpty() && preference(operators.peek(),str) ) // check if top of stack has greater than or equal preference to the current 'str' or not
					popValuesCalculateAndPushToStack();
				operators.push(str);
				break;
			case ")":
				while(!operators.isEmpty() && !operators.peek().equals("("))
					popValuesCalculateAndPushToStack();
				operators.pop(); // discard '('
		}
	}

	boolean preference(String str1, String str2) {

		if(str1.equals("("))
			return false;
		Map<String,Integer> pref = new HashMap<>();
		pref.put("+",1);
		pref.put("-",1);
		pref.put("*",2);
		pref.put("/",2);

		return (pref.get(str1) >= pref.get(str2));

		// if( (str1.equals("/") || str1.equals("*")) && (str2.equals("+") || str2.equals("-")) )
		// 	return false;
		// else
		// 	return true;
	}

	int calculate(int a, int b, String op) {

		switch(op) {
			case "+":
				return a+b;
			case "-":
				return a-b;
			case "*":
				return a*b;
			case "/":
				return b/a;
		}
		return -1;
	}

	void popValuesCalculateAndPushToStack() {

			int a = values.pop();
			int b = values.pop();
			int result = calculate(a,b,operators.pop());
			values.push(result);
	}

	public static void main(String args[]) {

		//String expression = "10 + 2 * 6";
		//String expression = "100 * 2 + 12";
		//String expression = "100 * ( 2 + 12 )";
		String expression = "100 * ( 2 + 12 ) / 14";
		ReversePolishNotation ob = new ReversePolishNotation();
		ob.evaluate(expression);
	}
}
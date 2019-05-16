package postfix_lab;

import java.util.Scanner;
import java.util.StringTokenizer;


public class EvaluatePostfix
{
	private static String getExpressionFromKeyboard()
	{
		Scanner sc = new Scanner(System.in);
//		System.out.print("What is your postfix arithmetic expression? ");
		System.out.print("Type your postfix arithmetic expression (e.g., 10 20 30 / *): ");
		return sc.nextLine();
	}


//==============================================
// TASK#1
//==============================================
// Returns if the given string is one of the four binary operators: +, -, /, and *
// Otherwise, return false;
	private static boolean isOperator(String s)
	{
		if(s.equals("+") || 
		   s.equals("-") ||
		   s.equals("/") ||
		   s.equals("*"))
			return true;
		return false;
	}


//==============================================
// TASK#2
//==============================================
// Returns result of binary operation, given two double values and a binary operator.
// Assume that only a valid operator is passed (i.e., +, -, /, or *)
	private static double evaluateOperation(double operand1, double operand2, String operator)
	{
		if(operator.equals("+"))
			return operand2 + operand1;
		if(operator.equals("-"))
			return operand2 - operand1;
		if(operator.equals("/"))
			return operand2 / operand1;
		if(operator.equals("*"))
			return operand2 * operand1;
		return 0.0;
	}


//==============================================
// TASK#3
// Refer to "Evaluating Postfix Expression" in handout_chap7.pdf.
//==============================================
	private static Double evaluateExpression(String expression)
	{
// ALSO, THIS VERSION WORKS FINE.
//		StackArrayBased myStack = new StackArrayBased();
		StackReferenceBased myStack = new StackReferenceBased();
//		StackListBased myStack = new StackListBased();
		double result = 0.0;
		double op1 = 0.0;
		double op2 = 0.0;

/*
// ALSO, THIS VERSION TOKENIZES THE GIVEN STRING, TOO.
		String [] tokens = str.split(" ");
		for (String s : tokens)
			System.out.println(s);
*/
		StringTokenizer st = new StringTokenizer(expression);

		while (st.hasMoreTokens()){
			String s = st.nextToken();
			if (isOperator(s)) {
				//=============================
				// YOUR CODE GOES HERE...
				//=============================
				if(!myStack.isEmpty())
				{
					op1 = Double.parseDouble(myStack.pop().toString());
				}

				if(!myStack.isEmpty())
				{
					op2 = Double.parseDouble(myStack.pop().toString());	
				}
				
				else // checking if (myStack.isEmpty())
				{
					//Error catching..not enough operators; Empty stack
					System.err.println("Error: Invalid post-fix expression...(not enough operands)");
					System.out.println(expression);
					return null;
				}
				
				result = evaluateOperation(op1, op2, s);  //evaluate expression

				myStack.push(result);	


			} else {
				//=============================
				// YOUR CODE GOES HERE...
				//=============================
				myStack.push(s);
			}
		}//end while
		
		//error if more than one item left in stack
		//pop then peek. if peek shows an item after popping 
		//there is an error, otherwise push the popped item back into stack for return
		if(!myStack.isEmpty())
		{
			double test1 = Double.parseDouble(myStack.pop().toString());
			
			if(myStack.isEmpty())
				myStack.push(test1);

			else {
				if(!myStack.isEmpty() || !myStack.peek().equals(test1))
				{
					//Error catching..not enough operators; more than one element in stack
					System.err.println("Error: Invalid post-fix expression...(not enough operators)");
					System.out.println(expression); //this prints before the system.err does... I dont know why
					return null;
				}
			}	
		}//end if, error checking for more than one item in stack
		
		return Double.valueOf(myStack.peek().toString());		
	}


	public static void main(String[] args)
	{
		String str = getExpressionFromKeyboard();
		if(evaluateExpression(str) != null)
			System.out.println(str + " = " + evaluateExpression(str));

  	} // end main


} // end EvaluatePostFix
import java.util.*;
//Given a string with only {}()[] determine if the string is valid i.e. the parenthesis are closed near each other
public class ValidParenthesis
{

	private static boolean isStringValid(String inputString)
	{
		HashMap<Character,Character> validMap = new HashMap<Character,Character>();
		validMap.put('(',')');
		validMap.put('[',']');
		validMap.put('{','}');
		Stack<Character> inputStack = new Stack<Character>();
		for(int i=0;i<inputString.length();i++)
		{
			char val = inputString.charAt(i);
			if(validMap.keySet().contains(val))
			{
				inputStack.push(inputString.charAt(i));
			}
			else if(validMap.values().contains(val))
			{
				//check what the last value in the stack is
				char lastStackVal = inputStack.peek();
				if(!inputStack.isEmpty() && val==validMap.get(lastStackVal))
					inputStack.pop();
				else
					return false;
			}
		}
		return inputStack.empty();
	}

	public static void main(String[] args)
	{

		// String inputString = "[]()";
		// String inputString = "{()}";
		String inputString = "{[]";
		// String inputString = '{[()]';
		String isValid = isStringValid(inputString)?" is valid":" is not valid";
		System.out.println("The String "+inputString+isValid);
	}
}
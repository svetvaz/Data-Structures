import java.util.*;

public class ReversePolishNotation
{

	private static int reversePolishEquate(String[] expr)
	{
		final String OPERATORS = "+-*/";
		int result = 0;
		Stack<Integer> myStack = new Stack<Integer>();
		for(String val: expr)
		{
			//if the element is not one of the operators push it on the stack
			if(!OPERATORS.contains(val))
			{
				myStack.push(Integer.parseInt(val));
			}
			else
			{
				//pop the last 2 values from the stack and apply the operator found
				Integer num1 = myStack.pop();
				Integer num2 = myStack.pop();
				String operator = val;
				//check which operator is to be applied
				int index = OPERATORS.indexOf(operator);
				switch(index){
					case 0:
						myStack.push(Integer.valueOf(num1+num2));
						break;
					case 1:
						myStack.push(Integer.valueOf(num1-num2));
						break;
					case 2:
						myStack.push(Integer.valueOf(num1*num2));
						break;
					case 3:
						myStack.push(Integer.valueOf(num1/num2));
						break;
				} // end switch
			}
		}//end for loop for the expression
		//now pop the value from the stack
		result = myStack.pop();
		return result;

	}

	public static void main(String[] args)
	{
		System.out.println("Enter the number of elements in the expression including operators:");
		int numberOfEle = Integer.parseInt(System.console().readLine());
		Scanner input = new Scanner(System.in);
		String[] expr = new String[numberOfEle];
		for(int i=0;i<numberOfEle;i++)
		{
			System.out.println("Please enter an element");
    		expr[i] = input.next();
		}
		System.out.println(Arrays.toString(expr));
		System.out.println(reversePolishEquate(expr));

	}
}
import java.util.*;

public class Stack
{
	//define the array
	long[] stackArr;
	int top;
	long maxSize;
	public Stack(int stackSize)
	{
		stackArr = new long[stackSize];
		top =-1;
		maxSize = stackSize;
	}

	public void push(long ele)
	{
		stackArr[++top] = ele;
	}

	public long pop()
	{
		return stackArr[top--];
	}

	public long peek()
	{
		return stackArr[top];
	}
	public boolean isEmpty()
	{
		if(top==-1)
			return true;
		return false;
	}

	public boolean isFull()
	{
		if(top==maxSize-1)
			return true;
		return false;
	}

	public long min()
	{
		long smallest = stackArr[0];
		for(int i=1;i<stackArr.length;i++)
		{
			if(stackArr[i]<smallest)
			{
				smallest = stackArr[i];
			}
		}
		return smallest;
	}


	public static void main(String[] args)
	{
		//push the elemts to the stack
		Stack myStack = new Stack(5);
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);
		myStack.push(5);
		//now pop
		long elePopped = myStack.pop();
		System.out.println("Popped ele:"+elePopped);
		// find the top element
		long topEle = myStack.peek();
		System.out.println("top ele:"+topEle);
		// find min element
		long minEle = myStack.min();
		System.out.println(minEle);

	}



}
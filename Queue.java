public class Queue
{
	long[] queueEle;
	int front;
	int rear;
	int maxSize;

	public Queue(int queueSize)
	{
		maxSize = queueSize;
		queueEle = new long[queueSize];
		front = -1;
		rear = maxSize-1;
	}

	public void enqueue(long ele)
	{
		//if queue is full
		if(isFull())
		{
			throw new IllegalStateException("Queue is full, cannot add any more elements");
		}
		//queue is empty
		else if(isEmpty())
		{
			front++;
			rear++;
			queueEle[rear] = ele;
		}
		else
		{
			rear = (rear+1)%maxSize;
			queueEle[rear] = ele;
		}
	}

	public long dequeue()
	{
		long val;
		//queue is empty
		if(isEmpty())
		{
			// throw exception
			throw new IllegalStateException("Queue is empty");
		}
		// if the queue has only 1 element
		else if(front==rear)
		{
			val = queueEle[front];
			front=-1;
			rear=-1;
		}
		else
		{
			val =  queueEle[front];
			front=(front-1)%maxSize;
		}
		return val;
	}

	public boolean isEmpty()
	{
		if(front==-1 && rear==-1)
			return true;
		return false;
	}

	public boolean isFull()
	{
		if((rear+1)%maxSize==front)
			return true;
		return false;
	}

	public static void main(String[] args)
	{
		//enter elements into the queue
		Queue myQueue = new Queue(5);
		myQueue.enqueue(1);
		myQueue.enqueue(2);
		myQueue.enqueue(3);
		myQueue.enqueue(4);
		myQueue.enqueue(5);
		// remove the last element
		long lastEle = myQueue.dequeue();
		System.out.println("The dequeued element:"+lastEle);
	}
}
public class SinglyLinkedList
{
	Node head;
	Node end;
	int size;

	public void display()
	{
		Node current = head;
		while(current!=null)
		{
			System.out.println("Node :"+current.data);
			current = current.link;
		}
	}

	//reverse linked list iteratively
	public void reverseIte()
	{	
		if(head==null) return;
		if(head.link==null)
		{
			return;
		}
		Node second = head.link;
		Node third = second.link;
		second.link = head;
		head.link = null;

		if(third==null) return;
		Node currentNode = third;
		Node prevNode = second;
		while(currentNode!=null)
		{
			Node nextNode = currentNode.link;
			currentNode.link = prevNode;
			//advance prev
			prevNode = currentNode;
			//advance currentNode
			currentNode = nextNode;
		}
		//reset head
		head = prevNode;
	}

	//reverse linked list recursively
	public void reverseRec(Node current)
	{
		if(current==null) return;
		if(current.link==null)
		{
			head = current;
			return;
		}
		reverseRec(current.link);
		current.link.link = current;
		current.link = null;
	}

	//add to the front of the list
	public void insertAtStart(int data)
	{
		Node newNode = new Node(data,null);
		size++;
		if(head==null)
		{
			head = newNode;
			end = head;
		}
		else
		{
			Node temp = head;
			newNode.link = temp;
			head = newNode;
		}
	}

	//add to the end of the linked list
	public void insertAtEnd(int data)
	{
		Node newNode = new Node(data,null);
		size++;
		if(head==null)
		{
			head = newNode;
			end = head;
		}
		else
		{
			end.link = newNode;
			end = newNode;
		}
	}

	// Does linked list have a cycle?
	// have 2 pointers slow & fast, if they overlap then linked list is cyclic
	public boolean hasCycle()
	{
		//iterate through the linked list
		Node slow = head; 
		Node fast = head;
		if(slow==null) return false;
		if(slow.link==null) return false;
		while(fast!=null && fast.link!=null)
		{
			slow = slow.link;
			fast = fast.link.link;
			if(slow==fast) return truel
		}
		return false;
	}

	public void removeDuplicatesFromList()
	{

	}

	// delete a node with given data from the linked list
	public void removeFromList(int data)
	{
		Node current = head;
		Node nextNode = current.link;
		if(current.data==data)
		{
			head = nextNode;
			return;
		}
		Node prevNode = current;
		current = nextNode;
		while(current!=null)
		{
			if(current.data==data)
			{
				//store the link node of this node
				Node next = current.link;
				// look at its previous node
				prevNode.link = next;
				return;
			}
			current =  current.link;
		}

	}

	public static void main(String[] args)
	{
		SinglyLinkedList llist = new SinglyLinkedList();
		llist.insertAtStart(10);
		llist.insertAtStart(20);
		llist.insertAtStart(30);
		llist.insertAtStart(40);
		llist.insertAtStart(50);
		llist.insertAtStart(60);
		llist.insertAtEnd(5);
		System.out.println("Displaying initial list");
		// Display the list
		llist.display();

		System.out.println("Now reversing list");
		//reverse the list
		llist.reverseRec(llist.head);

		System.out.println("Now displaying reversed list");
		//Display the reversed list
		llist.display();

		System.out.println("Now reversing list iteratively");
		//reverse the list iteratively
		llist.reverseIte();
		System.out.println("Now displaying reversed list");
		//Display the reversed list
		llist.display();

		//check if linked list has a cycle
		llist.hasCycle();

	}

}

class Node
{
	public int data;
	public Node link;

	public Node(int data,Node link)
	{
		this.data = data;
		this.link = link;
	}
}
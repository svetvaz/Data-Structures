
public class LinkedList
{
	Node start;
	Node end;
	int size;

	public LinkedList()
	{
		this.start = null;
		this.end = null;
		size=0;
	}

	public void insertAtStart(int data)
	{
		//create a new node with a null next link
		Node newNode = new Node(data,null);
		size++;
		//now check start and end values
		if(start==null)
		{
			start = newNode;
			end = start;
		}
		else
		{
			//reassign start and its link to another node
			newNode.setLink(start);
			//newly created node now becomes start
			start = newNode;
		}
	}

	public void insertAtEnd(int data)
	{
		//if start==null, 
		Node newNode = new Node(data,null);
		size++;
		if(start==null)
		{
			start = newNode;
			end = start;
		}
		else
		{
			end.setLink(newNode);
			end = newNode;
		}
	}

	public void insertAtPos(int data,int pos)
	{
		Node newNode = new Node(data,null);
		Node ptr = start;
		for(int i=0;i<size;i++)
		{
			if(i==pos)
			{
				ptr.setLink(newNode);
				ptr = newNode;
			}
		}
	}

	public void display()
	{
		while(start.getLink()!=null)
		{
			System.out.println(start.getData());
			start = start.getLink();
		}
		System.out.println(start.getData());
	}

	public Node reverseList()
	{
		//exit condition
		if(this.start==null) return start;
		if(this.start.getLink()==null)
		{
			//System.out.println(s.toString());
			return this.start;
		}
		//store the second node
		Node second = this.start.getLink();

		//set start link's next to null
		this.start.setLink(null);
		//System.out.println(s.toString());
		// do it for the rest of the nodes
		this.start = second;
		Node rest = reverseList();
		rest.setLink(this.start);
		return this.start;
	}

	public Node add2Lists(Node n1,Node n2)
	{
		Node p1 = n1, Node p2 = n2, Node p3 = this.start;
		int carry = 0;

		while(p1!=null || p2!=null)
		{
			if(p1!=null)
			{
				carry+=p1.getData();
				p1 = p1.getLink();
			}
			if(p2!=null)
			{
				carry+=p2.getData();
				p2 = p2.getLink();
			}
			p3 = new Node(carry%10,null);
			p3 = p3.getLink();
			carry/=10;
			if(carry==1)
			{
				p3.setLink(new Node(1,null));
			}
		}
		return this.start.getLink();
	}

	public boolean hasCycle()
	{
		//there are 2 pointers 
		//1. one moving 1 node at a time
		//2. second moving 2 nodes at a time
		//if they overlap at some point, it indicates there is a cycle
		Node slow = this.start;
		Node fast = this.start;
		if(this.start==null) return false;
		if(this.start.getLink()==null) return false;
		while(fast!=null && fast.getLink()!=null)
		{
			slow = slow.getLink();
			fast = fast.getLink().getLink();

			if(slow==fast)
				return true;
		}
		return false;

	}

	public Node merge2Lists(Node list1,Node list2)
	{
		Node p1 = list1;
		Node p2 = list2;
		Node p = this.start;

		while(p1!=null && p2!=null)
		{
			if(p1.getData()<p2.getData())
			{
				//assign the value of p1
				p.setLink(p1);
				//advance p1
				p1 = p1.getLink();
			}
			else
			{
				p.setLink(p2);
				p2 = p2.getLink();
			}
			//advance the list that is getting created
			p = p.getLink();
		}
		//now copy over the remaining items if any from either list
		while(p1!=null)
		{
			p.setLink(p1);
			//advance p1
			p1 = p1.getLink();
			p = p.getLink();
		}
		while(p2!=null)
		{
			p.setLink(p2);
			//advance p1
			p2 = p2.getLink();
			p = p.getLink();
		}

		return p.getLink();

	}

	public Node removeDuplicates()
	{
		Node temp = this.start;

		while(temp!=null && temp.getLink()!=null)
		{
			Node prev = temp;
			temp = temp.getLink();
			if(prev.getData()==temp.getData())
			{
				//duplicate exists
				//first save the pointer of current node
				Node link = temp.getLink();
				//set the prev's pointer to this node
				prev.setLink(link);
			}
			//advance the pointer
			temp = link;
		}
		return this.start;
	}

	public static void main(String[] args)
	{
		LinkedList myList = new LinkedList();
		myList.insertAtStart(1);
		myList.insertAtStart(2);
		myList.insertAtStart(3);
		myList.insertAtStart(4);
		myList.insertAtStart(5);
		myList.display();
		System.out.println("Now reversing list");
		myList.reverseList();
		myList.display();
	}
}

 class Node
	{
		Node link;
		int data;

		public Node(int d,Node next)
		{
			link = next;
			data = d;
		}

		public int getData()
		{	
			return this.data;
		}

		public void setData(int d)
		{
			this.data = d;
		}
		public Node getLink()
		{
			return this.link; 
		}
		public void setLink(Node n)
		{
			this.link = n;
		}

		public String toString(){
			return data+"";
		}

	}



class FlattenBinaryTree
{
	Node root = new Node(1);

	private static flattenTree(Node current)
	{
		//traverse left
		Stack<Node> myStack = new Stack<Node>();
		while(current!=null)
		{
			//if right child exists, push it onto stack
			if(current.leftChild!=null)
			{
				if(current.rightChild!=null)
					myStack.push(curren.rightChild);
				current.rightChild = current.leftChild;
				current.leftChild=null;
			}
			if(!myStack.empty() && current.rightChild==null)
			{
				current.rightChild= myStack.pop();
			}
			
			current = current.rightChild;

		}

	}

	private static flattenTreeRec(Node current)
	{
		//insert left subtree, then append the right subtree at every node
		Node temp = current.rightChild;
		current.rightChild = current.leftChild;
		current.leftChild=null;
		current = flattenTreeRec(current.rightChild);
		if(temp!=null)
		{
			//append right subtree back to main tree
			current.rightChild = temp;
			current = flattenTreeRec(current.rightChild);
		}
		return current;
	}


	public static void main(String[] args)
	{
		FlattenBinaryTree tree = new FlattenBinaryTree();
		Node node1 = new Node(2);
		Node node2 = new Node(5);
		root.leftChild = node1
		root.rightChild = node2;
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		node1.leftChild = node3;
		node1.rightChild = node4;
		Node node5 = new Node(6);
		node2.leftChild = node5;
		tree.flattenTree(this.root);
		tree.flattenTreeRec(this.root);
	}
}

class Node
{
	public int data;
	public Node leftChild;
	public Node rightChild;

	public Node(int data)
	{
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
}
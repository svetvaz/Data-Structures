public class BinaryTree1
{
	Node root;

	public void addNode(int key)
	{
		Node newNode = new Node(key);
		if(root==null)
			root = newNode;
		else
		{
			//focus-> node in focus
			Node focus =  root;
			//this is the parent of our future node that is going to be inserted
			Node parent;

			while(true)
			{
				parent = focus;
				//check if the node belongs to the left subtree or right subtree
				if(key<focus.key)
				{
					//belongs to left
					focus = focus.leftChild;
					if(focus==null)
					{
						parent.leftChild = newNode;
						return;
					}
				}
				else
				{
					focus = focus.rightChild;
					if(focus==null)
					{
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public void inOrderTraversal(Node focus)
	{
		if(focus!=null)
		{
			inOrderTraversal(focus.leftChild);
			System.out.println(focus.key);
			inOrderTraversal(focus.rightChild);
		}
	}

	public void preOrderTraversal(Node focus)
	{
		if(focus!=null)
		{
			System.out.println(focus.key);
			preOrderTraversal(focus.leftChild);
			preOrderTraversal(focus.rightChild);
		}
	}

	public void postOrderTraversal(Node focus)
	{
		if(focus!=null)
		{
			postOrderTraversal(focus.leftChild);
			postOrderTraversal(focus.rightChild);
			System.out.println(focus.key);
		}
	}

	public Node findNode(int key)
	{
		Node focus = root;
		while(focus.key!=key)
		{
			if(key<focus.key)
			{
				focus = focus.leftChild;
			}
			else
			{
				focus = focus.rightChild;
			}
			if(focus==null)
			{
				return null;
			}

		}
		return focus;
	}

public static void main(String[] args)
{
	BinaryTree1 tree = new BinaryTree1();
	tree.addNode(20);
	tree.addNode(10);
	tree.addNode(50);
	tree.addNode(40);
	tree.addNode(60);
	tree.addNode(5);
	System.out.println("In Order Traversal");
	tree.inOrderTraversal(tree.root);
	System.out.println("Pre Order Traversal");
	tree.preOrderTraversal(tree.root);
	System.out.println("Post Order Traversal");
	tree.postOrderTraversal(tree.root);
}

}

class Node
{
	int key;
	Node leftChild;
	Node rightChild;

	Node(int key)
	{
		this.key = key;
	}

	public String toString()
	{
		return this.key+"";
	}	

}
//A binary tree is one that has the left node smaller than the root and the 
//right node larger than the root
import java.util.LinkedList;
import java.util.Queue;
public class BinaryTree
{

	Node root;
	public void addNode(int key)
	{
		
		Node newNode = new Node(key);

		if(root==null)
		{
			root = newNode;
			System.out.println("Added root node"+newNode.key);
		}
	   else
	   {
	   	//create a focus node
		Node focus = root;
		Node parent;
		while(true)
		{
			parent = focus;
			if(key<focus.key)
			{
				focus = focus.leftChild;
				if(focus == null)
				{
					parent.leftChild = newNode;
					System.out.println("Added node"+newNode.key);
					return;
				}
			}
			else
			{
				focus = focus.rightChild;
				if(focus ==null)
				{
					parent.rightChild = newNode;
					System.out.println("Added node"+newNode.key);
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

	public boolean searchNode(int key)
	{	
		Node focus = root;
		while(key!=focus.key)
		{
			if(key<focus.key)
			{
				focus = focus.leftChild;
			}
			else
			{
				focus = focus.rightChild;
			}
			if(focus == null)
				return false;
		}
		return true;
	}

	public void printRootToLeafPaths(Node current, int[] pathArr,int len,int num)
	{
		if(current!=null)
		{
			pathArr[len] = current.key;
			len++;
			if(current.leftChild==null && current.rightChild==null) 
			{
				// // boolean isSumZero = isSumZero(pathArr);
				// if(isSumZero)
				// {
					num++;
					printPath(pathArr,num);
				// }
			}
			else
			{
				//traverse left & right sub trees
				printRootToLeafPaths(current.leftChild, pathArr,len,num);
				printRootToLeafPaths(current.rightChild, pathArr,len,num);
			}
		}
	}

	public void findAllPaths(Node current)
	{
		//algo
		//traverse: root, left child, right child
		// add each visited node to list
		// once we reach leaf go back to parent and add only those unvisited nodes

	}

	private boolean isSumZero(int[] pathArr)
	{
		int sum = 0;
		for(int i=0;i<pathArr.length;i++)
		{
			sum+=pathArr[i];
		}
		if(sum==0) return true;
		return false;
	}


	public void levelOrderTraversal(Node current)
	{
		Queue<Node> nodeQueue = new LinkedList<Node>();
		// put values into queue
		if(current==null) return;
		nodeQueue.add(current);
		while(!nodeQueue.isEmpty())
		{
			int queueSize = nodeQueue.size();
			while(queueSize>0)
			{
				current = nodeQueue.remove();
				System.out.print(" "+current.key);
				if(current.leftChild!=null) nodeQueue.add(current.leftChild);
				if(current.rightChild!=null) nodeQueue.add(current.rightChild);
				queueSize--;
			}
			System.out.println(" ");
		}
	}

	public void printSums(Node current)
	{
		
	}


	public void printPath(int[] pathArr,int num)
	{
		System.out.println("Path"+num+":");
		String delimiter = "";
		for(int i=0;i<pathArr.length;i++)
		{
			System.out.print(delimiter);
			System.out.print(pathArr[i]);
			delimiter = "-";
		}
	}


	public static void main(String[] args)
	{
		// create a binary tree
		BinaryTree tree = new BinaryTree();
		tree.addNode(10);
		tree.addNode(-15);
		tree.addNode(35);
		tree.addNode(-40);
		tree.addNode(-5);
		tree.addNode(10);
		tree.addNode(60);
		//Now traverse through the tree
		System.out.println("In Order Traversal - Sorts the values by key");
		tree.inOrderTraversal(tree.root);
		System.out.println("Pre Order Traversal");
		tree.preOrderTraversal(tree.root);
		System.out.println("Post Order Traversal");
		tree.postOrderTraversal(tree.root);
		//lets try searching for a node given its key
		String node1Status = tree.searchNode(30)?"found":"not found";
		System.out.println("The node 30 was "+node1Status);
		//lets try searching for another non existent node given its key
		String node2Status = tree.searchNode(90)?"found":"not found";
		System.out.println("The node 90 was "+node1Status);
		// System.out.println("Printing paths");
		// int[] pathArr = new int[7];
		// int len =0;
		// tree.printRootToLeafPaths(tree.root,pathArr,len,1);
		Queue<Node> nodeQueue = new LinkedList<Node>();
		tree.levelOrderTraversal(tree.root);
	}

}

class Node
{
	int key;
	Node leftChild;
	Node rightChild;

	public Node(int key)
	{
		this.key = key;
	}

	public String toString()
	{
		return this.key+"";
	}

}
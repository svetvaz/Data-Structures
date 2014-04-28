package com.datastructsandalgo;

import java.util.LinkedList;
import java.util.Queue;

class BinarySearchTree{
	BinarySearchTree left;
	BinarySearchTree right;
	int data;


	/**
	 * This method inserts nodes into the binary search tree based upon the following rule:
	 * data<root  ---> insert it to the left of the root
	 * data>=root ---> insert it to the right of the root
	 * @param node : the root of the tree
	 * @param newData : data of the new node that has to be inserted
	 * @return root of the new tree after insertion
	 */
	public static BinarySearchTree insert(BinarySearchTree node, int newData){
		if(node==null){
			node = new BinarySearchTree();
			node.data = newData;
		}
		else if(node.data>newData){
			node.left = insert(node.left,newData);
		}
		else{
			node.right = insert(node.right,newData);
		}
		
		return node;
	}
	
	/**
	 * This method print a binary search tree in order
	 * The rule followed for in order traversal is Left Node----> Root -----> Right Node
	 * @param root of the tree
	 */
	public static void printInOrder(BinarySearchTree root){
		//left, root, right
		if(root==null)
			return;
		if(root.left!=null)
			{
				printInOrder(root.left);
			}
			System.out.println(root.data);
			if(root.right!=null)
			{
				printInOrder(root.right);
			}
		
	}
	
	
	/**
	 * This method prints a binary search tree in pre order
	 * The rule followed for pre order traversal is Root----> Left Node -----> Right Node
	 * @param root of the tree
	 */
	public static void printPreOrder(BinarySearchTree root){
		// root,left, right
		if(root==null)
			return;
		System.out.println(root.data);
		if(root.left!=null)
			{
				printInOrder(root.left);
			}
			
			if(root.right!=null)
			{
				printInOrder(root.right);
			}
		
	}
	
	
	/**
	 * This method prints a binary search tree in post order
	 * The rule followed for post order traversal is Left Node -----> Right Node ----> Root
	 * @param root of the tree
	 */
	public static void printPostOrder(BinarySearchTree root){
		//left,right,root
		if(root==null)
			return;
		if(root.left!=null)
			{
				printInOrder(root.left);
			}
			
			if(root.right!=null)
			{
				printInOrder(root.right);
			}
			System.out.println(root.data);
		
	}
	
	/**
	 * This method prints a binary search tree in level order
	 * The rule followed for level order print is print all of the nodes at each level of the tree
	 * @param root of the tree
	 */
	public static void printLevelOrder(BinarySearchTree root)
	{
		if(root==null)
			return;
		Queue<BinarySearchTree> myQueue = new LinkedList<BinarySearchTree>();
		myQueue.add(root);
		int level = 0;
		while(!myQueue.isEmpty()){
		int count = myQueue.size();
		printQueue(myQueue,level);
		level++;
		for(int i=0;i<count;i++){	
			BinarySearchTree head = myQueue.peek();
			if(head.left!=null)
			{
				myQueue.add(head.left);
				
			}
			if(head.right!=null){
				myQueue.add(head.right);
			}
			myQueue.remove();
	}
		}
		
	}
	
	/**
	 * This method prints all the leaves in a binary search tree
	 * @param root of the tree
	 */
	public static void printLeaves(BinarySearchTree root){
		if(root==null)
			return;
		if(root.left==null && root.right==null)
			{
			System.out.println(root.data);
			}
		
		printLeaves(root.left);
		printLeaves(root.right);
	
	}
	
	public static void printQueue(Queue<BinarySearchTree> queue,int count){
		System.out.println("Level:"+count+"\n");
		for(BinarySearchTree queueItem:queue){
			System.out.print(queueItem.data);
			System.out.print('\t');
		}
		System.out.print('\n');
	}
	
	/**
	 * This method check if the binary search tree is balanced
	 * The rule followed for balanced tree : If the difference between the levels of 2 leaf nodes <=1, the tree is balanced
	 * @param root of the tree
	 */
	public static boolean isTreeBalanced(BinarySearchTree root){
		return (maxDepth(root) - minDepth(root)<=1);
		
	}
	
	private static int maxDepth(BinarySearchTree root){
		if (root==null) return 0;
		return 1+ Math.max(maxDepth(root.left),maxDepth(root.right));
	}
	
	private static int minDepth(BinarySearchTree root){
		if (root==null) return 0;
		return 1+ Math.min(minDepth(root.left),minDepth(root.right));
	}
	
	private static BinarySearchTree createTree(BinarySearchTree tree) {
		tree = insert(tree,1);
		   tree = insert(tree,2);
		   tree = insert(tree,3);
		   tree = insert(tree,-1);
		   tree = insert(tree,0);
		   tree = insert(tree,4);
		return tree;
	}
	/**
     * Main : creation of input tree and printing each traversal
     */
	public static void main(String args[])
	{
	   BinarySearchTree tree = null;
	   tree = createTree(tree);
	   System.out.println("Printing inorder:");
	   printInOrder(tree);
	   System.out.println("Printing preorder:");
	   printPreOrder(tree);
	   System.out.println("Printing postorder:");
	   printPostOrder(tree);
	   System.out.println("Printing level order:");
	   printLevelOrder(tree);
	   System.out.println("Printing leaves:");
	   printLeaves(tree);
	   boolean balanced = isTreeBalanced(tree);
	   if(balanced){
		   System.out.println("Tree is balanced");
		}else{
			System.out.println("Tree is not balanced");
			}
	}



	
	
	
}
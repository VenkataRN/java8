package com.javapractise;

import java.util.Stack;

class Node {
	public int val;
	public Node left;
	public Node right;
	
	Node(int val){
		this.val = val;
		left = right = null;
		
	}
	
	public void visit(int val) {
		System.out.println(val);
	}
	
	public void traversePreOrderWithoutRecursion(Node root) {
	    Stack<Node> stack = new Stack<Node>();
	    Node current = root;
	    stack.push(root);
	    while(!stack.isEmpty()) {
	        current = stack.pop();
	        visit(current.val);
	        
	        if(current.right != null) {
	            stack.push(current.right);
	        }    
	        if(current.left != null) {
	            stack.push(current.left);
	        }
	    }        
	}
	
	public void traversePostOrderWithoutRecursion(Node root) {
	    Stack<Node> stack = new Stack<Node>();
	    Node current = root;
	    stack.push(root);
	    while(!stack.isEmpty()) {
	        current = stack.pop();
	        visit(current.val);
	        
	        if(current.left != null) {
	            stack.push(current.left);
	        }
	        
	        if(current.right != null) {
	            stack.push(current.right);
	        }    

	    }        
	}
	
	public void traversePostOrderWithRecursion(Node nodeElement) {

		if (nodeElement != null) {
			traversePostOrderWithRecursion(nodeElement.left);
			traversePostOrderWithRecursion(nodeElement.right);
			System.out.println(nodeElement.val);
		}
	}
	
	
};

public class DepthFirstSearchBinaryTree {
	public static void main(String[] args) {
		Node node = new Node(1);
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(4);
		node.left.right = new Node(5);
		node.right.left = new Node(6);
		node.right.right = new Node(7);
		
		Node root = node;
		node.traversePreOrderWithoutRecursion(root);
		
		System.out.println("--- traversePostOrderWithoutRecursion---");
		node.traversePostOrderWithoutRecursion(root);
		
		System.out.println("--- traversePostOrderWithRecursion---");
		node.traversePostOrderWithRecursion(root);
		
	}

}


/*

1
2
4
5
3
6
7
--- traversePostOrderWithoutRecursion---
1
3
7
6
2
5
4
--- traversePostOrderWithRecursion---
4
5
2
6
7
3
1

*/

package com.javapractise;

import java.util.Stack;

class Node {
	int val;
	Node left;
	Node right;
	
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
		
	}

}

package leetcode.practise;

import java.util.List;
import java.util.LinkedList;

class TreeNode{
	public int val;
	public TreeNode right;
	public TreeNode left;
	
	TreeNode(int i){
		this.val = i;
	}
}

public class PrintAverageOfABinaryTreeAtDepthLevel {
	
	public static int[] average(TreeNode rootNode) {
		
		TreeNode head = rootNode;
		LinkedList<TreeNode> queue = new LinkedList<>();
		
		if (head != null) {
			queue.add(head);
		}
		
		while(!queue.isEmpty()) {
			float sum = 0;
			int count = queue.size();
			
			for (int i = 0; i< count ; i++) {
				TreeNode node1 = queue.poll();
				sum += node1.val;
				
				if (node1.left != null)
				queue.add(node1.left);
				if (node1.right != null)
				queue.add(node1.right);
				
			}
			System.out.println(sum/(count+0.0));
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		TreeNode root= new TreeNode(3);
		root.left  = new TreeNode(3);
		root.right = new TreeNode(20);
		root.right.left  = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		System.out.println("Binary Tree Average");
		
		average(root);
			
	}

}

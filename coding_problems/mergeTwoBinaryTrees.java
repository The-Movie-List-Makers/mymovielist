import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        if (root1 == null) return root2;
        if (root2 == null) return root1;

        root1.val += root2.val;

        if (root1.left == null && root1.right == null && root2.left == null && root2.right == null) return root1;

        if (root1.left == null) {
        	if (root2.left != null) {
        		root1.left = new TreeNode();
        		q1.add(root1.left);
        	}
        } else {
        	q1.add(root1.left);
        }
        if (root1.right == null) {
        	if (root2.right != null) {
        		root1.right = new TreeNode();
        		q1.add(root1.right);
        	}
        } else {
        	q1.add(root1.right);
        }
        if (root2.left == null) {
        	if (root1.left != null) {
        		root2.left = new TreeNode();
        		q2.add(root2.left);
        	}
        } else {
        	q2.add(root2.left);
        }
        if (root2.right == null) {
        	if (root1.right != null) {
        		root2.right = new TreeNode();
        		q2.add(root2.right);
        	}
        } else {
        	q2.add(root2.right);
        }

        while (q1.size() > 0 && q2.size() > 0) {
        	TreeNode next1 = q1.remove();
        	TreeNode next2 = q2.remove();

        	next1.val += next2.val;

        	if (next1.left == null) {
	        	if (next2.left != null) {
	        		next1.left = new TreeNode();
	        		q1.add(next1.left);
	        	}
	        } else {
	        	q1.add(next1.left);
	        }
	        if (next1.right == null) {
	        	if (next2.right != null) {
	        		next1.right = new TreeNode();
	        		q1.add(next1.right);
	        	}
	        } else {
	        	q1.add(next1.right);
	        }
	        if (next2.left == null) {
	        	if (next1.left != null) {
	        		next2.left = new TreeNode();
	        		q2.add(next2.left); 
	        	}
	        } else {
	        	q2.add(next2.left); 
	        }
	        if (next2.right == null) {
	        	if (next1.right != null) {
	        		next2.right = new TreeNode();
	        		q2.add(next2.right);
	        	}
	        } else {
	        	q2.add(next2.right);
	        }
        }

        return root1;
    }
}
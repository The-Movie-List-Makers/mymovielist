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
	public int getDepth (TreeNode node, int depth) {
		if (node == null) return 0;

		int maxDepth = depth;
		if (node.left != null) {
			int thisDepth = getDepth(node.left, depth + 1);
			if (thisDepth > maxDepth) maxDepth = thisDepth;
		}
		if (node.right != null) {
			int thisDepth = getDepth(node.right, depth + 1);
			if (thisDepth > maxDepth) maxDepth = thisDepth;
		}

		return maxDepth;
	}

    public int maxDepth(TreeNode root) {
        int maxDepth = getDepth(root, 1);

        return maxDepth;
    }
}
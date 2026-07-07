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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        maxSum(root);
        return ans;
    }

    private int maxSum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int maxLeft = maxSum(root.left);
        int maxRight = maxSum(root.right);

        ans = Math.max(Math.max(ans, maxLeft + maxRight + root.val), root.val);

        return Math.max(Math.max(maxLeft, maxRight) + root.val, 0);
    }
}

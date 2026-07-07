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
    public boolean isBalanced(TreeNode root) {
        return Balanced(root).bal;
    }

    private Details Balanced(TreeNode root) {
        if(root == null) {
            return new Details(true,0);
        }

        var left = Balanced(root.left);
        var right = Balanced(root.right);

        return new Details(
            left.bal && right.bal && (Math.abs(right.height - left.height) <= 1),
            Math.max(right.height, left.height) + 1
        );
    }

    private class Details {
        boolean bal;
        int height;

        Details(boolean bal, int height) {
            this.bal = bal;
            this.height = height;
        }
    }
}

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
    public boolean isValidBST(TreeNode root) {
        return validate(root).bin;
    }

    private Res validate(TreeNode root) {
        if(root == null) {
            return new Res(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Res left = validate(root.left);
        Res right = validate(root.right);

        return new Res( root.val > left.max && root.val < right.min && left.bin && right.bin,
        Math.min(root.val, left.min),
        Math.max(root.val, right.max));
    }

    private class Res{
        boolean bin;
        int min;
        int max;

        Res(boolean bin, int min, int max) {
            this.bin = bin;
            this.max = max;
            this.min = min;
        }

    }
}

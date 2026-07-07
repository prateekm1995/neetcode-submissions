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
    int ans;
    public int goodNodes(TreeNode root) {
        ans =0;
        good(root, Integer.MIN_VALUE);
        return ans;
    }

    private void good(TreeNode root, int max) {
        if(root == null) {
            return;
        }
        if(root.val >= max){
            max = root.val;
            ans++;
        }
        good(root.left, max);
        good(root.right, max);
    }
}

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
    int ans=Integer.MIN_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k-1);
        return ans;

    }

    private int inorder(TreeNode root, int k) {
        if(root == null) {
            return k;
        }
        k = inorder(root.left, k);
        if(k == 0) {
            ans = root.val;
        }
        k--;
        if(k >= 0) {
        k = inorder(root.right, k);
        }
        return k;
        
    }

}

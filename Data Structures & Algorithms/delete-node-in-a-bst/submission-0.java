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
    public TreeNode deleteNode(TreeNode root, int val) {
        if(root == null) {
            return root;
        }
        if(val < root.val) {
            root.left = deleteNode(root.left, val);
        } else if (val > root.val) {
            root.right = deleteNode(root.right, val);
        } else {
            if(root.left != null && root.right != null) {
                TreeNode c = root.right;
                while(c.left != null) {
                    c = c.left;
                }
                c.left = root.left;
                return root.right;
            } else if(root.left == null) {
                return root.right;
            } else return root.left;
        }
        return root;
    }
}
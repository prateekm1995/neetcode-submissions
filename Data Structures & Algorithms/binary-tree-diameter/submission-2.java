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
    public int diameterOfBinaryTree(TreeNode root) {

        return dia(root).dia;
    }

    private Ans dia(TreeNode root) {
        if(root == null) {
            return new Ans(0,0);
        }
        Ans left = dia(root.left);
        Ans right = dia(root.right);

        Ans ans = new Ans(0,0);
        ans.dia = Math.max(Math.max(left.dia, right.dia), left.dep + right.dep);
        ans.dep = Math.max(left.dep, right.dep) + 1;
        
        return ans;

    }

    private int maxDepth(TreeNode root) {
        return root==null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    private class Ans{
        int dia;
        int dep;

        Ans(int dia, int dep) {
            this.dia= dia;
            this.dep= dep;
        }
    }
}

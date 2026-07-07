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
    public int maxDepth(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        int depth=0;
        if(root != null) {
            q.add(root);
        }

        while(!q.isEmpty()) {
            depth++;
            int lsize = q.size();
            for(int i=0 ; i< lsize ; i++) {
                TreeNode node = q.poll();
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
                
            }
            
            
        }
        return depth;
    }

}

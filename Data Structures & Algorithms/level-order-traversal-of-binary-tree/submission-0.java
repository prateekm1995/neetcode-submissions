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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Deque<TreeNode> q = new ArrayDeque<>();
        if(root != null) {
            q.add(root);
        }

        while(!q.isEmpty()) {
            int lsize = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            for(int i=0 ; i< lsize ; i++) {
                TreeNode node = q.poll();
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
                level.add(node.val);
            }
            result.add(level);
            
        }
        return result;
    }
}

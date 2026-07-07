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
    HashMap<Integer, List<TreeNode>> map; 
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        map = new HashMap<>();
        int subHeight = height(subRoot);
        fillTree(root);

        if(map.containsKey(subHeight)) {
           return map.get(subHeight).stream().anyMatch(r -> isSameTree(r,subRoot));
        }
        return false;

    }

    private int  fillTree(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int h = Math.max(fillTree(root.left) ,fillTree(root.right)) + 1;

        map.computeIfAbsent(h, k -> new ArrayList<>()).add(root);
        return h;
    }

    private int height(TreeNode root) {
        return root == null ? 0 : Math.max(height(root.left), height(root.right)) +1;
    }

        public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        } else if((p == null && q != null)
         || (p != null && q == null)) {
            return false;
         }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && p.val == q.val;
    }
}

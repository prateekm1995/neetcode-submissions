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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            if(cur != null) {
                ans.add(cur.val);
                if(cur.right != null) {
                    stack.push(cur.right);
                }
                cur = cur.left;
            } else {
                cur = stack.pop();
            }
        }
        return ans;
    }
}
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder,0, preorder.length-1, 0, preorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if(pl > pr) {
            return null;
        }
        if(pl == pr) {
            return new TreeNode(preorder[pl]);
        }

        TreeNode root = new TreeNode(preorder[pl]);
        int mid = search(inorder, il, ir, preorder[pl]);
        root.left = buildTree(preorder, inorder,pl+1,pl + (mid-il) ,il, mid-1);
        root.right = buildTree(preorder, inorder,pl + (mid-il) +1,pr,mid+1, ir);

        return root;

    }

    private int search(int[] inorder, int l , int r, int val) {
        for(int i=l ; i<=r;i++) {
            if(inorder[i] == val){
                return i;
            }
        }
        return r;

    }
}

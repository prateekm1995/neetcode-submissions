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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        String s = new String();
        s = traverse(root, s);
        System.out.println("serial: " + s.substring(0, s.length()-1));
        return s.toString();
    }

    private String traverse(TreeNode root, String s) {
        if(root == null) {
            return s+"1001,";
        }
        s += String.valueOf(root.val);
        s += ",";
        s = traverse(root.left, s);
        s = traverse(root.right, s);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<TreeNode> stack = new ArrayDeque();
        Deque<Boolean> visited = new ArrayDeque();

        if(data.equals("")){
            return null;
        }

        String[] temp = data.split(",");
        ArrayDeque<String> nodes = new ArrayDeque(Arrays.asList(temp));

        TreeNode root = new TreeNode(Integer.valueOf(nodes.poll()));

        stack.push(root);
        visited.push(false);

        int i=1;
        while(!stack.isEmpty() && !nodes.isEmpty()) {
            TreeNode node = stack.pop();
            if(!visited.pop())  {
                stack.push(node);
                visited.push(true);
                TreeNode left = new TreeNode(Integer.valueOf(nodes.poll()));
                if(left.val != 1001){
                    node.left = left;
                    stack.push(left);
                    visited.push(false);
                }
            } else {
                if(nodes.isEmpty()) {
                    break;
                }
                TreeNode right = new TreeNode(Integer.valueOf(nodes.poll()));
                if(right.val != 1001){
                    node.right = right;
                    stack.push(right);
                    visited.push(false);
                }
            }
        }

        return root;
    }
}

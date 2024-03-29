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
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        convertBSTUtils(root);
        return root;
    }
    private void convertBSTUtils(TreeNode node) {
        if (node == null) {
            return;
        }
        
        convertBSTUtils(node.right);
        sum += node.val;
        node.val = sum;
        convertBSTUtils(node.left);
    }
}


//Using static variable
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
    static int sum;
    static {
        sum = 0;
    }
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        convertBSTUtils(root);
        return root;
    }
    private void convertBSTUtils(TreeNode node) {
        if (node == null) {
            return;
        }
        
        convertBSTUtils(node.right);
        sum += node.val;
        node.val = sum;
        convertBSTUtils(node.left);
    }
}

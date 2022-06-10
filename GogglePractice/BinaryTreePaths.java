//DFS solution
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        String currPath = Integer.toString(root.val);
        if ( root.left == null && root.right == null) {
            res.add(currPath);
        }
        if ( root.left != null ) {
            dfs(root.left, currPath, res);
        }
        if ( root.right != null ) {
            dfs(root.right, currPath, res);
        }
        return res;
    }
    
    void dfs(TreeNode node, String currPath, List<String> res){
        currPath += "->" + node.val;
        if ( node.left == null && node.right == null) {
            res.add(currPath);
            return;
        }
        if ( node.left != null ) {
            dfs(node.left, currPath, res);
        }
        if ( node.right != null ) {
            dfs(node.right, currPath, res);
        }
    }
}

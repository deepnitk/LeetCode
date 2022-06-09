//Naive approach using storing preOrder traversal storage
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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> preOrder = new ArrayList<>();
        constructPreOrder(root, preOrder);
        return preOrder.get(k-1);
    }
    
    void constructPreOrder(TreeNode root, ArrayList<Integer> preOrder) {
        if(root == null) {
            return;
        }
        constructPreOrder(root.left, preOrder);
        preOrder.add(root.val);
        constructPreOrder(root.right, preOrder);
    }
}

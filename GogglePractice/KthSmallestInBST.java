//Naive approach using storing inOrder traversal storage
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
        ArrayList<Integer> inOrder = new ArrayList<>();
        constructPreOrder(root, inOrder);
        return inOrder.get(k-1);
    }
    
    void constructPreOrder(TreeNode root, ArrayList<Integer> inOrder) {
        if(root == null) {
            return;
        }
        constructPreOrder(root.left, inOrder);
        inOrder.add(root.val);
        constructPreOrder(root.right, inOrder);
    }
}

//Better Approach : without storing inOrder traversal
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

        TreeNode smallest = constructPreOrder(root, new int[]{k});
        if( smallest != null)
            return smallest.val;
        return -1;
    }
    
    TreeNode constructPreOrder(TreeNode root, int[] k) {
        if(root == null) {
            return null;
        }
        TreeNode left = constructPreOrder(root.left, k);
        if (left != null) {
            return left;
        }

        k[0]--;
        if (k[0] == 0) 
            return root;
        return constructPreOrder(root.right, k);
    }
}

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

//Recursive solution
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return inorderUtils(root, res);
    }
    
    private List<Integer> inorderUtils(TreeNode root, List<Integer> res){
        
        if(root!= null){
            inorderUtils(root.left, res);
            res.add(root.val);
            inorderUtils(root.right, res);    
        }
        return res;
    }
}

//Iterative solution
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        
        while(!st.isEmpty() || root != null){
            //Go to extreme left node
            while(root!=null){
                st.push(root);
                root=root.left;
            }
            //pop node that will be the inorder node
            root = st.pop();
            //add to answer list
            res.add(root.val);
            //now that leftmost child might have right child. so make root point to right child
            root = root.right;  
        }
        return res;
    }
    
    
}

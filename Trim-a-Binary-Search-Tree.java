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
    public void helper(TreeNode root, int low, int high){
        if(root==null) return;
        while(root.left!=null){
            if(root.left.val<low)  root.left = root.left.right;
            else if(root.left.val>high) root.left = root.left.left;
            else break;
        }
        while(root.left!=null && root.left.val>high){ //Trim the tree
            root.left = root.left.left;
        }
        while(root.left!=null && root.left.val<low){ //Trim the tree
            root.left = root.left.right;
        }
        while(root.right!=null && root.right.val>high){ //Trim the tree
            root.right = root.right.left;
        }
        while(root.right!=null && root.right.val<low){ //Trim the tree
            root.right = root.right.right;
        }
        helper(root.left,low,high);
        helper(root.right,low,high);
    }
    public TreeNode trimBST(TreeNode root, int low, int high) {
        TreeNode parent = new TreeNode(Integer.MAX_VALUE);
        parent.left = root;
        helper(parent,low,high);
        return parent.left;
    }
}
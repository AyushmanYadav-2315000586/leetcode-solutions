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
        int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    int dfs(TreeNode root){
        if(root==null) return 0;
        int l=Math.max(0,dfs(root.left));
        int r=Math.max(0,dfs(root.right));

        int sum=l+r+root.val;
        max=Math.max(sum,max);
        return Math.max(l,r) + root.val;
    }
}
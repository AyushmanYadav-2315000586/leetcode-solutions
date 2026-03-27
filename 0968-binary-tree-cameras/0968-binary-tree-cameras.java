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

    int cameras =0;

    public int minCameraCover(TreeNode root) {
        if(minC_(root)==-1) cameras++;
        return cameras;    
    }

    int minC_(TreeNode root){
        if(root == null) return 1;

        int lChild=minC_(root.left);
        int rChild=minC_(root.right);

        if(lChild==-1||rChild==-1){
            cameras++;
            return 0;
        }
        if(lChild==0 || rChild==0) return 1;

        return -1;
    }

}
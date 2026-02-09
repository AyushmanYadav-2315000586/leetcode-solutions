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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> arr= new ArrayList<>();
        inOrder(root,arr);

        int l=0;
        int r=arr.size()-1;
        return construct(l,r,arr);
    }
    TreeNode construct(int l, int r, ArrayList<Integer> arr){
        if(l>r){
            return null;
        }
        int mid = l+(r-l)/2;

        TreeNode root= new TreeNode(arr.get(mid));
        root.left=construct(l,mid-1,arr);
        root.right=construct(mid+1,r,arr);
        return root;
    }
    public void inOrder(TreeNode root, ArrayList<Integer> arr){
        if(root==null){
            return;
        }
        inOrder(root.left,arr);
        arr.add(root.val);
        inOrder(root.right,arr);
    }
}
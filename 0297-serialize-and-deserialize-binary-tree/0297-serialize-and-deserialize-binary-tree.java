/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    int idx=0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb= new StringBuilder();
        buildString(root,sb);
        return sb.toString();
    }

    void buildString(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("null,");
            return;
        }

        sb.append(root.val).append(",");
        buildString(root.left,sb);
        buildString(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[]arr= data.split(",");
        idx=0;
        return buildTree(arr);
    }
    TreeNode buildTree(String[]arr){
        if(arr[idx].equals("null")){
            idx++;
            return null;
        }

        TreeNode node= new TreeNode(Integer.parseInt(arr[idx]));
        idx++;
        node.left=buildTree(arr);
        node.right=buildTree(arr);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
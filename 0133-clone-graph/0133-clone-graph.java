/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node,Node> map= new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node clone= new Node(node.val);
        map.put(node,clone);

        for(Node n: node.neighbors){
            clone.neighbors.add(cloneGraph(n));
        }
        return clone;
    }
}



// class Solution {
//     HashMap<Node,Node> map= new HashMap<>();
//     public Node cloneGraph(Node node) {
//         if(node==null) return null;
//         Node clone = new Node(node.val);
//         map.put(node,clone);
//         dfs(node,clone);
//         return clone;

//     }
//     void dfs(Node node, Node clone){
//         for(Node n: node.neighbors){
//             if(!map.containsKey(n)){
//                Node clone_node= new Node(n.val); 
//                map.put(n,clone_node);
//                clone.neighbors.add(clone_node);
//                dfs(n,clone_node);
//             }
//             else{
//                 clone.neighbors.add(map.get(n));
//             }
//         }
//     }

// }
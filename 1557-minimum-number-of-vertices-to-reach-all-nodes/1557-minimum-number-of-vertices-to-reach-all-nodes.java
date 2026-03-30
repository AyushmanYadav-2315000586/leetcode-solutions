class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        int[]idg= new int[n];

        for(List<Integer> e: edges){
            idg[e.get(1)]++;
        }

        List<Integer> res= new ArrayList<>();

        for(int i=0; i<n; i++){
            if(idg[i]==0){
                res.add(i);
            }
        }
        return res;
    }
}
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;

        HashMap<Integer,List<Integer>> map= new HashMap<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int k=i+j;
                map.putIfAbsent(k, new ArrayList<>());
                map.get(k).add(mat[i][j]);
            }
        }

        List<Integer> res= new ArrayList<>();
        boolean flip=true;
        for(int k=0; k<=m+n-2; k++){
            List<Integer> dia= map.get(k);

            if(dia==null) continue;

            if(flip){
                Collections.reverse(dia);
            }
            res.addAll(dia);
            flip=!flip;
        }

        int []arr= new int[res.size()];

        for(int i=0; i<arr.length; i++){
            arr[i]=res.get(i);
        }
        return arr;

    }
}
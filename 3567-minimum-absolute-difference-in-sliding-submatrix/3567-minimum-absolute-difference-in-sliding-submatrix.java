class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;


        int [][]res=new int[m-k+1][n-k+1];

        for(int i=0; i<=m-k; i++){
            for(int j=0; j<=n-k; j++){
                TreeSet<Integer> val= new TreeSet<>();

                for(int r=i; r<=i+k-1; r++){
                    for(int c=j; c<=j+k-1; c++){
                        val.add(grid[r][c]);
                    }
                }
                if(val.size()==1) continue;
                int min=Integer.MAX_VALUE;

                Integer prev=null;
                for(int v: val){
                    if(prev!=null){
                        min=Math.min(min, v-prev);
                    }
                    prev=v;
                }

                res[i][j]= min;
            }
        }
        return res;
    }
}
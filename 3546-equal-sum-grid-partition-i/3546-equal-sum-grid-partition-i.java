class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int[]rs=new int[m];
        int[]cs=new int[n];

        long total=0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                total+=grid[i][j];
                rs[i]+=grid[i][j];
                cs[j]+=grid[i][j];
            }
        }

        if(total%2!=0){
            return false;
        }

        long upper=0;
        for(int i=0; i<m-1; i++){
            upper+=rs[i];
            if(upper==total-upper){
                return true;
            }
        }

        long side=0;

        for(int j=0; j<n-1; j++){
            side+=cs[j];
            if(side==total-side){
                return true;
            }
        }

        return false;
    }
}
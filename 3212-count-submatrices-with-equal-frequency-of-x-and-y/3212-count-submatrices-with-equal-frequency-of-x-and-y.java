class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][]c_x=new int [m][n];
        int[][]c_y=new int [m][n];
        int cnt=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){

                c_x[i][j]=(grid[i][j]=='X')?1:0;
                c_y[i][j]=(grid[i][j]=='Y')?1:0;

                if(i>0){
                    c_x[i][j]+=c_x[i-1][j];
                    c_y[i][j]+=c_y[i-1][j];
                }

                if(j>0){
                    c_x[i][j]+=c_x[i][j-1];
                    c_y[i][j]+=c_y[i][j-1];
                }

                if(i>0 && j>0){
                    c_x[i][j]-=c_x[i-1][j-1];
                    c_y[i][j]-=c_y[i-1][j-1];
                }

                if(c_x[i][j]==c_y[i][j] && c_x[i][j]>0){
                    cnt++;
                }

            }
        }
        return cnt;
    }
}
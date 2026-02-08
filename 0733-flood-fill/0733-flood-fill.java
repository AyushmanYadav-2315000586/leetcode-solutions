class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor=image[sr][sc];
        int [][]ans= image;
        int delRow[]={-1,0,1,0};
        int delCol[]={-0,1,0,-1};
        dfs(sr,sc,ans,image, color, delRow, delCol, iniColor);
        return ans;
    }
    void dfs(int row, int col, int [][]ans, int [][]image, int color, int delRow[], int delCol[], int iniColor){
        ans[row][col]=color;
        int n=image.length;
        int m=image[0].length;
        for(int i=0; i<4; i++){
            int nr=row+delRow[i];
            int nc=col+delCol[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && image[nr][nc]==iniColor && ans[nr][nc]!=color){
                dfs(nr,nc,ans,image,color,delRow,delCol,iniColor);
            }
        }
    }
}
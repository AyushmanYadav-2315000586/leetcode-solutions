class Solution {
    public int numSpecial(int[][] mat) {
        int cnt=0;
        int m=mat.length;
        int n=mat[0].length;

        int []row= new int [m];
        int []col= new int [n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]==1){
                    row[i]++;
                    col[j]++;
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]==1 && row[i]==1 && col[j]==1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}












// class Solution {
//     int m,n;
//     public int numSpecial(int[][] mat) {
//         int cnt=0;
//         m=mat.length;
//         n=mat[0].length;

//         for(int i=0; i<m; i++){
//             for(int j=0; j<n; j++){
//                 if(mat[i][j]==1){
//                     if(check(mat,i,j)){
//                         cnt++;
//                     }
//                 }
//             }
//         }
//         return cnt;
//     }

//     boolean check(int[][]mat, int row, int col){
//         for(int j=0; j<n; j++){
//             if(j!=col && mat[row][j]==1){
//                 return false;
//             }
//         }
//         for(int i=0; i<m; i++){
//             if(i!=row && mat[i][col]==1){
//                 return false;
//             }
//         }
//         return true;
//     }
// }
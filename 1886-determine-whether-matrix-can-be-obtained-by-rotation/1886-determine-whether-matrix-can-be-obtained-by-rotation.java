class Solution {
    int n;
    public boolean findRotation(int[][] mat, int[][] target) {
        n=mat.length;
        for(int c=1; c<=4; c++){
            boolean equal=true;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(mat[i][j]!=target[i][j]){
                        equal=false;
                        break;
                    }
                }
                if(!equal) break;
            }
            if(equal) return true;
            
            rotate(mat);
        }
        return false;
    }
    void rotate(int[][]mat){
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
        for(int i=0; i<n; i++){
            int l=0,r=n-1;
            while(l<r){
                int temp=mat[i][l];
                mat[i][l]=mat[i][r];
                mat[i][r]=temp;
                l++;
                r--;
            }
        }
    }
}
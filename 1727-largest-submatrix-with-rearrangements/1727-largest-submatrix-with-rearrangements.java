class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        int maxArea=0;
        for(int r=0;r<m; r++){
            for(int c=0; c<n; c++){
                if(r>0 && matrix[r][c]==1){
                    matrix[r][c]+=matrix[r-1][c];
                }
            }
            int[] arr= matrix[r].clone();
            Arrays.sort(arr);
            for(int i=0; i<n; i++){
                int base=n-i;
                int height=arr[i];
                maxArea=Math.max(maxArea,base*height);
            }
        }
        return maxArea;

    }
}
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int neg=0;
        int min=Integer.MAX_VALUE;
        int n=matrix.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]<0){
                    neg++;
                }
                min=Math.min(Math.abs(matrix[i][j]),min);
            }
        }
        long sum=0;
        if(neg%2==0){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    sum+=Math.abs(matrix[i][j]);
                }
            }
        }
        else{
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    sum+=Math.abs(matrix[i][j]);
                }
            }
            sum=sum-min-min;
        }
        return sum;

    }
}
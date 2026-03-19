class Solution {
    public int matrixSum(int[][] nums) {
        int sum=0;
        int n=nums[0].length;
        int m=nums.length;

        for(int i=0; i<m; i++){
            Arrays.sort(nums[i]);
        }

        for(int i=0; i<n; i++){
            int max=0;
            for(int j=0; j<m; j++){
                max=Math.max(max,nums[j][i]);
            }
            sum+=max;
        }
        return sum;
    }
}
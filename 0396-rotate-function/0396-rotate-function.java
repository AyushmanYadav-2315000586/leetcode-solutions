class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum=0;
        int f=0;
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            sum+=nums[i];
            f+=i*nums[i];
        }
        for(int k=0; k<n; k++){
            int newF=f+sum-n*nums[n-1-k];
            max=Math.max(newF,max);
            f=newF;
        }
        return max;
    }
}
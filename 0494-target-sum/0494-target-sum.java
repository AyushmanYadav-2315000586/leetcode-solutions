class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, 0,0,target);
    }
    int solve(int []nums, int i, int curr, int target){
        if(i==nums.length){
            if(curr==target){
                return 1;
            }
            else {
                return 0;
            }
        }

        int plus=solve(nums,i+1,curr+nums[i],target);
        int minus=solve(nums,i+1,curr-nums[i],target);

        return plus+minus;
    }
}
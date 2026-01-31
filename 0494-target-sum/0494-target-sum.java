class Solution {
    HashMap<String,Integer> map= new HashMap<>();
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
        String key=i+"_"+curr;
        if(map.containsKey(key)){
            return map.get(key);
        }

        int plus=solve(nums,i+1,curr+nums[i],target);
        int minus=solve(nums,i+1,curr-nums[i],target);
        map.put(key,plus+minus);
        return map.get(key);
    }
}
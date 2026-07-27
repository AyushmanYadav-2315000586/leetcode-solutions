class Solution {
    public int uniqueXorTriplets(int[] nums) {
        HashSet<Integer> set= new HashSet<>();
        int n=nums.length;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                set.add(nums[i]^nums[j]);
            }
        }
        HashSet<Integer>ans= new HashSet<>();
        for(int val:set){
            for(int num:nums){
                ans.add(val^num);
            }
        }
        return ans.size();
    }
}
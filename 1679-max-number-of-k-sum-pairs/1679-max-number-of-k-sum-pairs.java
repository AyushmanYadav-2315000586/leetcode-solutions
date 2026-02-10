class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0,r=nums.length-1;

        int cnt=0;
        while(l<r){
            int sum=nums[l]+nums[r];
            if(sum==k){
                cnt++;
                l++;
                r--;
            }
            else if(sum>k){
                r--;
            }
            else{
                l++;
            }
        }
        return cnt;
    }
}
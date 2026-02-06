class Solution {
    public int minRemoval(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);

        int max=0;
        int l=0,r=0;

        while(r<n){
            while((long)nums[l]*k<nums[r]){
                l++;
            }
            max=Math.max(r-l+1,max);
            r++;
        }
        return n-max;
    }
}
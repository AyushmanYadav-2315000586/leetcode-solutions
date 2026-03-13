class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int cnt=0;
        int l=0;
        int r=0;
        int n=nums.length;
        int pro=1;
        if(k<=1){
            return 0;
        }
        while(r<n){
            pro*=nums[r];
            while(l<n && pro>=k){
                pro/=nums[l];
                l++;
            }
            cnt=cnt+(r-l+1);
            r++;
        }
        return cnt;
    }
}
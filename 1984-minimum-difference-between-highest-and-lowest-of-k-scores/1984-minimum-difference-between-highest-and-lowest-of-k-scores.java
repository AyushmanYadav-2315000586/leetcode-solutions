class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n=nums.length;
        int minDiff=Integer.MAX_VALUE;
        Arrays.sort(nums);
        int l=0; int r=k-1;
        while(r<n){
            int minEl=nums[l];
            int maxEl=nums[r];
            minDiff=Math.min(minDiff, maxEl-minEl);
            l++;
            r++;
        }
        return minDiff;

    }
}
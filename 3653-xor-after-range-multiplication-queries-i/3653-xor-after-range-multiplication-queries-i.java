class Solution {
    int mod=1_000_000_007;
    int val;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int h=0;
        int n=queries.length;
        while(h<n){
            int l=queries[h][0];
            int r=queries[h][1];
            int k=queries[h][2];
            int v=queries[h][3];

            while(l<=r){
                nums[l]=(int)((1L*nums[l]*v)%mod);
                l+=k;
            }
            val=nums[0];
            for(int i=1; i<nums.length; i++){
                val=val^nums[i];
            }
            h++;
        }
        return val;
    }
}
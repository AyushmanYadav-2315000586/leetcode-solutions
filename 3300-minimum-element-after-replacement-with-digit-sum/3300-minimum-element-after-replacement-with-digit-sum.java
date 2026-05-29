class Solution {
    public int minElement(int[] nums) {
        int n=nums.length;
        int res=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int val=0;
            String s=String.valueOf(nums[i]);
            for(char ch: s.toCharArray()){
                val+=ch-'0';
            }
            res=Math.min(res,val);
        }
        return res;
    }
}
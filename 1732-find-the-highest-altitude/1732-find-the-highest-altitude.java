class Solution {
    public int largestAltitude(int[] gain) {
        int res=0;
        int n=gain.length;
        int val=0;
        for(int i=0; i<n; i++){
            res=res+(gain[i]);
            val=Math.max(val,res);
        }
        return val;
    }
}
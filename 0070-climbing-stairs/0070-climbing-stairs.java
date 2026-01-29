class Solution {
    public int climbStairs(int n) {
        int prev=1, prev2=2;
        for(int i=2; i<=n; i++){
            int temp=prev+prev2;
            prev=prev2;
            prev2=temp;
        }
        return prev;
    }
}
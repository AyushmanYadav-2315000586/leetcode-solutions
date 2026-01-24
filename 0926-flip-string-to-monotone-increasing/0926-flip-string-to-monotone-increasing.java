class Solution {
    public int minFlipsMonoIncr(String s) {
        int n=s.length();
        int [][]dp= new int[n+1][2];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(s,0,0,n,dp);
    }
    public int solve(String s, int idx, int prev, int n, int [][]dp){
        if(idx>=n){
            return 0;
        }
        if(dp[idx][prev]!=-1){
            return dp[idx][prev];
        }
        int flip   = Integer.MAX_VALUE;
        int no_flip= Integer.MAX_VALUE;
        if(s.charAt(idx)=='0'){
            if(prev==1){
                flip=1+solve(s,idx+1,1,n,dp);
            }
            else{
                flip=1+solve(s,idx+1,1,n,dp);
                no_flip=solve(s,idx+1,0,n,dp);
            }
        }
        else if(s.charAt(idx)=='1'){
            if(prev==1){
                no_flip=solve(s,idx+1,1,n,dp);
            }
            else{
                flip=1+solve(s,idx+1,0,n,dp);
                no_flip=solve(s,idx+1,1,n,dp);
            }
        }
        return dp[idx][prev]=Math.min(flip,no_flip);
    }
}
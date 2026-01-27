class Solution {
    final int mod=1000000007;
    public int numberOfArrays(String s, int k) {
        int n=s.length();
        int dp[]= new int[n+1];
        Arrays.fill(dp,-1);
        return solve(0,s,k,n,dp);
    }
    int solve(int start, String s, int k, int n, int []dp){
        if(start>=n)
            return 1;
    
        if(s.charAt(start)=='0'){
            return 0;
        }
        if(dp[start]!=-1){
            return dp[start];
        }
        int ans=0;
        long num=0;
        for(int end=start; end<n; end++){
            num=(num*10) + (s.charAt(end)-'0');
            if(num>k){
                break;
            }
            ans=(ans%mod+solve(end+1,s,k,n,dp)%mod)%mod;
        }
        return dp[start]=ans;
    }

}
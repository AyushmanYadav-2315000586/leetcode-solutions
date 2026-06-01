class Solution {
    int mod=(int)1e9+7;
    int[][]dp;
    String st[]={"RYG", "RGY", "RYR", "RGR", "YRG", "YGR", "YGY", "YRY", "GRY", "GYR", "GRG", "GYG"};

    public int numOfWays(int n) {
        int res=0;
        dp= new int[n][12];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0; i<12; i++){
            res=(res+solve(n-1, i))%mod;
        }
        return res;
    }

    int solve(int n, int prev){
        if(n==0){
            return 1;
        }
        if(dp[n][prev]!=-1){
            return dp[n][prev];
        }
        int res=0;
        String last=st[prev];

        for(int i=0; i<12; i++){
            if(i==prev){
                continue;
            }
            String cP=st[i];
            boolean conflict=false;
            for(int col=0; col<3; col++){
                if(cP.charAt(col)==last.charAt(col)){
                    conflict=true;
                    break;
                }
            }

            if(!conflict){
                res=(res+solve(n-1,i))%mod;
            }
        }
        return dp[n][prev]=res;
    }
}
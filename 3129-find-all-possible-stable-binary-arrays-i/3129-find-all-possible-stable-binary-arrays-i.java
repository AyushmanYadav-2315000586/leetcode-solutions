class Solution {
    int mod=1000000007;
    public int numberOfStableArrays(int zero, int one, int limit) {
        int dp[][][]= new int [201][201][2];
        for(int i=0; i<201; i++){
            for(int j=0; j<201; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        dp[0][0][0]=1;
        dp[0][0][1]=1;
        
        for(int i=0; i<=one; i++){
            for(int j=0; j<=zero; j++){
                if(i==0 && j==0) continue;
                int res=0;
                for(int len=1; len<=Math.min(j,limit); len++){
                    res=(res+dp[i][j-len][0])%mod;
                }
                dp[i][j][1]=res;
                res=0;
                for(int len=1; len<=Math.min(i,limit); len++){
                    res=(res+dp[i-len][j][1])%mod;
                }
                dp[i][j][0]=res;
            }
        }

        return (dp[one][zero][1]+dp[one][zero][0])%mod;
    }
}
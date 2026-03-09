class Solution {
    int mod=1000000007;
    public int numberOfStableArrays(int zero, int one, int limit) {
        int dp[][][]= new int [201][201][2];
        for(int i=0; i<201; i++){
            for(int j=0; j<201; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        int swz=solve(zero,one,0,limit,dp);
        int swo=solve(zero,one,1,limit,dp);
        return (swz+swo)%mod;
    }
    int solve(int zero, int one, int lastOne,int limit, int dp[][][]){
        if(zero==0 && one==0){
            return 1;
        }
        if(dp[zero][one][lastOne]!=-1){
            return dp[zero][one][lastOne];
        }
        int res=0;
        if(lastOne==1){
            for(int len=1; len<=Math.min(zero,limit); len++){
                res=(res+solve(zero-len,one,0,limit,dp))%mod;
            }
        }
        else{
            for(int len=1; len<=Math.min(one,limit); len++){
                res=(res+solve(zero,one-len,1,limit,dp))%mod;
            }
        }
        return dp[zero][one][lastOne]=res;
    }
}
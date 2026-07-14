class Solution {
    int mod=1_000_000_007;
    int [][][]dp;
    public int subsequencePairCount(int[] nums) {
        dp= new int[nums.length+1][201][201];
        for(int[][]row:dp){
            for(int []col:row){
                Arrays.fill(col,-1);
            }
        }
        return solve(nums,0,0,0);
    }
    int solve(int []nums, int i, int f, int s){
        if(i==nums.length){
            if(f!=0 && s!=0 && f==s){
                return 1;
            }
            return 0;
        }

        if(dp[i][f][s]!=-1){
            return dp[i][f][s];
        }

        int skip=solve(nums,i+1,f,s);
        int t1=solve(nums,i+1,gcd(f,nums[i]),s);
        int t2=solve(nums,i+1,f,gcd(s,nums[i]));

        return dp[i][f][s]=(int)((0L+skip+t1+t2)%mod);
    }

    int gcd(int a, int b){
        return b==0?a:gcd(b,a%b);
    }
}
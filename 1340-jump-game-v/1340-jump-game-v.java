class Solution {
    int n;
    int []dp;
    public int maxJumps(int[] arr, int d) {
        n=arr.length;
        dp=new int[n];
        Arrays.fill(dp,-1);
        int max=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            max=Math.max(max,solve(arr,i,d));
        }
        return max;
    }

    int solve(int []arr, int i, int d){
        int res=1;
        if(dp[i]!=-1){
            return dp[i];
        }
        for(int j=i-1; j>=Math.max(0,i-d); j--){
            if(arr[j]>=arr[i]) break;

            res=Math.max(res,1+solve(arr,j,d));
        }
        for(int j=i+1; j<=Math.min(n-1,i+d); j++){
            if(arr[j]>=arr[i]) break;

            res=Math.max(res,1+solve(arr,j,d));
        }
        return dp[i]=res;
    }
}
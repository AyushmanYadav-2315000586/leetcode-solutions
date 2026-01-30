class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int max=0;
        int start=0;
        int[][]dp=new int [n+1][n+1];
        for(int i=0; i<n+1; i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(solve(s,i,j,dp)==1){
                    if(j-i+1>max){
                        max=j-i+1;
                        start=i;
                    }
                }
            }
        }
        return s.substring(start,max+start);
    }
    int solve(String s, int i, int j, int [][]dp){
        if(i>=j){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]=solve(s,i+1,j-1,dp);
        }
        return dp[i][j]=0;
    }
}
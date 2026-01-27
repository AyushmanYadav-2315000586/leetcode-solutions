class Solution {
    public int longestStrChain(String[] words) {
        int n=words.length;
        int[][]dp=new int[n+1][n+1];
        for(int i=0; i<=n; i++){
            Arrays.fill(dp[i],-1);
        }
        Arrays.sort(words,(a,b)-> Integer.compare(a.length(),b.length()));
        return lis(0,-1,words,dp);
    }
    public int lis(int idx, int prev, String[]words, int[][]dp){
        if(idx==words.length){
            return 0;
        }
        if(prev!=-1 && dp[idx][prev+1]!=-1){
            return dp[idx][prev+1];
        }
        int take=0;
        if(prev==-1 || isPred(words[prev],words[idx])){
            take=1+lis(idx+1,idx,words,dp);
        }
        int skip=lis(idx+1, prev, words,dp);
        return dp[idx][prev+1]=Math.max(take,skip);
    }
    public boolean isPred(String prev, String curr){
        int m=prev.length();
        int n=curr.length();
        if(m>=n || n-m!=1){
            return false;
        }

        int i=0,j=0;
        while(i<m && j<n){
            if(prev.charAt(i)==curr.charAt(j)){
                i++;
            }
            j++;
        }
        return i==m;
    }
}
class Solution {
    int []ps;
    int n;
    int t[];
    public int stoneGameVIII(int[] stones) {
        n=stones.length;

        ps= new int [n];
        ps[0]=stones[0];
        t= new int[n+1];
        Arrays.fill(t,Integer.MIN_VALUE);
        for(int i=1; i<n; i++){
            ps[i]=ps[i-1]+stones[i];
        }

        return solve(1);
    }

    int solve(int i){
        if(i==n-1){
            return ps[n-1];
        }
        if(t[i]!=Integer.MIN_VALUE){
            return t[i];
        }
        int take=ps[i]-solve(i+1);
        int skip=solve(i+1);

        return t[i]=Math.max(take,skip);
    }
}
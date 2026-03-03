class Solution {
    static final int mod=1000000007;
    public int concatenatedBinary(int n) {
        long res=0;
        for(int i=1; i<=n; i++){
            int dig=log2(i)+1;
            res=((res<<dig)%mod+i)%mod;
        }
        return (int) res;
    }
    int log2(int n){
        return (int) ((Math.log(n)/Math.log(2)));
    }
}
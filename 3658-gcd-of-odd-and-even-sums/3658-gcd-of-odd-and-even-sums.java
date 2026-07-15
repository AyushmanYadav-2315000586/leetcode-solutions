class Solution {
    public int gcdOfOddEvenSums(int n) {
        int os=0;
        int es=0;
        int odd=1;
        int even=2;
        for(int i=1; i<=n; i++){
            os+=odd;
            es+=even;

            odd+=2;
            even+=2;
        }
        return gcd(os,es);
    }
    int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
}
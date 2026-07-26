class Solution {
    public int maxProduct(int n) {
        int mx1=0,mx2=0;
        while(n>0){
            int rem=n%10;
            if(mx1<rem){
                mx2=mx1;
                mx1=rem;
            }
            else if(mx2<rem){
                mx2=rem;
            }

            n/=10;
        }
        return mx1*mx2;
    }
}
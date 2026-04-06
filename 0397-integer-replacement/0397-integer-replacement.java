class Solution {
    public int integerReplacement(int nu) {
        int cnt=0;
        long n=nu;
        while(n>1){
            if(n%2==0){
                n/=2;
            }
            else{
                if((n==3)||(n&2)==0){
                    n--;
                }
                else{
                    n++;
                }
            }
            cnt++;
        }
        return cnt;
    }
}
class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev=n%2;
        n=n/2;
        int temp=n;
        while(temp>0){
            if((temp%2)==prev){
                return false;
            }
            else if(temp%2==0){
                prev=0;
            }
            else if(temp%2!=0){
                prev=1;
            }
            temp=temp/2;
        }
        return true;
    }
}
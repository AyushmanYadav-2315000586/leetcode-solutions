class Solution {
    public int minSwaps(String s) {
        int b=0;
        int minB=0;
        for(char ch: s.toCharArray()){
            if(ch=='['){
                b--;
            }
            else{
                b++;
            }
            minB=Math.max(minB,b);
        }
        return (minB+1)/2;
    }
}
class Solution {
    public int minOperations(String s) {
        int s_0=0;
        int s_1=0;

        for(int i=0; i<s.length(); i++){
            if(i%2==0 && s.charAt(i)!='0'){
                s_0++;
            }
            else if(i%2!=0 && s.charAt(i)=='0'){
                s_0++;
            }
        }
        for(int i=0; i<s.length(); i++){
            if(i%2==0 && s.charAt(i)=='0'){
                s_1++;
            }
            else if(i%2!=0 && s.charAt(i)!='0'){
                s_1++;
            }
        }

        return Math.min(s_0, s_1);
    }
}
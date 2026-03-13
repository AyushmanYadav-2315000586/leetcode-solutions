class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i=s.length()-1;
        int j=t.length()-1;
        int s_s=0;
        int s_t=0;
        while(i>=0 || j>=0){
            while(i>=0){
                if(s.charAt(i)=='#'){
                    s_s++;
                    i--;
                }
                else if(s_s>0){
                    s_s--;
                    i--;
                }
                else{
                    break;
                }
            }
            while(j>=0){
                if(t.charAt(j)=='#'){
                    s_t++;
                    j--;
                }
                else if(s_t>0){
                    s_t--;
                    j--;
                }
                else{
                    break;
                }
            }

            char ch_f=i<0?'$':s.charAt(i);
            char ch_s=j<0?'$':t.charAt(j);

            if(ch_f!=ch_s){
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}
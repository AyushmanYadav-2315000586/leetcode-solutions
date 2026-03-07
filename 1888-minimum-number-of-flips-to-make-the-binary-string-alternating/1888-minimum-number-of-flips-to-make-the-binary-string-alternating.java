class Solution {
    public int minFlips(String s) {
        int s_0=0,s_1=0;
        int ans=Integer.MAX_VALUE;
        String ss=s+s;
        for(int i=0; i<ss.length(); i++){
            if(i%2==0 && ss.charAt(i)!='0'){
                s_0++;
            }
            if(i%2!=0 && ss.charAt(i)=='0'){
                s_0++;
            }

            if(i%2==0 && ss.charAt(i)=='0'){
                s_1++;
            }
            if(i%2!=0 && ss.charAt(i)!='0'){
                s_1++;
            }


            if(i>=s.length()){
                int j=i-s.length();
                
                if(j%2==0 && ss.charAt(j)!='0'){
                    s_0--;
                }
                if(j%2!=0 && ss.charAt(j)=='0'){
                    s_0--;
                }

                if(j%2==0 && ss.charAt(j)=='0'){
                    s_1--;
                }
                if(j%2!=0 && ss.charAt(j)!='0'){
                    s_1--;
                }
            }
            if(i>=s.length()-1){
                ans=Math.min(ans,Math.min(s_0,s_1));
            }
        }
        return ans;
    }
}
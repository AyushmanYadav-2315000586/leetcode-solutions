class Solution {
    public String minWindow(String s, String t) {
        int []freq= new int [128];
        int l=0;
        int r=0;
        int cnt=t.length();
        int len=Integer.MAX_VALUE;
        int start=0;
        for(int i=0; i<t.length(); i++){
            freq[t.charAt(i)]++;
        }
        while(r<s.length()){
            if(freq[s.charAt(r)]>0){
                cnt--;
            }
            freq[s.charAt(r)]--;
            r++;
            while(cnt==0){
                if(r-l<len){
                    len=r-l;
                    start=l;
                }
                freq[s.charAt(l)]++;

                if(freq[s.charAt(l)]>0){
                    cnt++;
                }
                l++;
            }
        }
        return (len==Integer.MAX_VALUE)?"":s.substring(start,start+len);
    }
}
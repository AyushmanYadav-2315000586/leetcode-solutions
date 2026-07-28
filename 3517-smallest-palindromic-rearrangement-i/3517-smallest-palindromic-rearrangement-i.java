class Solution {
    public String smallestPalindrome(String s) {
        int []cnt= new int [26];
        for(char c: s.toCharArray()){
            cnt[c-'a']++;
        }

        char mid=0;
        StringBuilder left=new StringBuilder();
        for(int i=0; i<26; i++){
            for(int j=0; j<cnt[i]/2; j++){
                left.append((char) ('a'+i));
            }

            if(cnt[i]%2==1){
                mid=(char)('a'+i);
            }
        }

        String s1=left.toString();
        String s2=left.reverse().toString();

        if(mid==0){
            return s1+s2;
        }

        return s1+mid+s2;


    }
}
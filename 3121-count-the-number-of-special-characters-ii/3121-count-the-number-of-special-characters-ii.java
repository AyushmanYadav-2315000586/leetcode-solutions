class Solution {
    public int numberOfSpecialChars(String word) {
        int[]small= new int[26];
        int[]big=new int[26];
        Arrays.fill(small,-1);
        Arrays.fill(big,-1);

        for(int i=0; i<word.length(); i++){
            if(Character.isLowerCase(word.charAt(i))){
                small[word.charAt(i)-'a']=i;
            }
            else{
                if(big[word.charAt(i)-'A']==-1){
                    big[word.charAt(i)-'A']=i;
                }
            }
        }
        int cnt=0;
        for(int i=0; i<26; i++){
            if(small[i]!=-1 && big[i]!=-1 && small[i]<big[i]){
                cnt++;
            }
        }
        return cnt;
    }
}
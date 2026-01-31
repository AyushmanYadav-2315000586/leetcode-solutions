class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char small=0;
        int tar= target-'0';
        for(int i=0; i<letters.length; i++){
            int num=letters[i]-'0';
            if(tar<num){
                return letters[i];
            }
        }
        return letters[0];
    }
}
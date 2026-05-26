class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> set= new HashSet<>();

        for(int i=0; i<word.length(); i++){
            set.add(word.charAt(i));
        }
        int cnt=0;
        for(char i='a'; i<='z'; i++){
            if(set.contains(i) && set.contains(Character.toUpperCase(i))){
                cnt++;
            }
        }
        return cnt;
    }
}
class Solution {
    public String[] findWords(String[] words) {
        int []freq= new int[26];

        for(char ch: "qwertyuiop".toCharArray()){
            freq[ch-'a']=1;
        }
        for(char ch: "asdfghjkl".toCharArray()){
            freq[ch-'a']=2;
        }
        for(char ch: "zxcvbnm".toCharArray()){
            freq[ch-'a']=3;
        }


        List<String> res= new ArrayList<>();

        for(String word: words){
            String w=word.toLowerCase();
            int r=freq[w.charAt(0)-'a'];

            boolean valid=true;

            for(int i=1; i<w.length(); i++){
                if(freq[w.charAt(i)-'a']!=r){
                    valid=false;
                    break;
                }
            }

            if(valid) res.add(word);
        }


        return res.toArray(new String[0]);
    }
}
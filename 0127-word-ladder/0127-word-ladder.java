class Pair{
    String word;
    int size;
    Pair(String word, int size){
        this.word=word;
        this.size=size;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(beginWord,1));
        int len=wordList.size();
        HashSet<String> set= new HashSet<>();
        for(int i=0; i<len; i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);
        while(!q.isEmpty()){
            String w=q.peek().word;
            int s=q.peek().size;
            if(w.equals(endWord)){
                return s;
            }
            q.remove();

            for(int i=0; i<w.length(); i++){
                for(char ch='a'; ch<='z'; ch++){
                    char []rA=w.toCharArray();
                    rA[i]=ch;
                    String newWord=new String(rA);

                    if(set.contains(newWord)==true){
                        set.remove(newWord);
                        q.add(new Pair(newWord,s+1));
                    }
                }
            }
        }
        return 0;
    }
}
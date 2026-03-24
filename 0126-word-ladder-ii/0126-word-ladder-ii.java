class Solution {
    String b;
    HashMap<String,Integer> map;
    List<List<String>> ans;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> set= new HashSet<>(wordList);
        
        Queue<String>q= new LinkedList<>();
        b=beginWord;
        q.add(beginWord);
        map= new HashMap<>();
        map.put(beginWord,1);

        int size=beginWord.length();

        set.remove(beginWord);

        while(!q.isEmpty()){
            String word=q.peek();
            int steps=map.get(word);
            q.remove();

            if(word.equals(endWord)) break;

            for(int i=0; i<size; i++){
                for(char ch='a'; ch<='z'; ch++){
                    char rA[]=word.toCharArray();
                    rA[i]=ch;
                    String newWord= new String(rA);
                    if(set.contains(newWord)){
                        q.add(newWord);
                        set.remove(newWord);
                        map.put(newWord,steps+1);
                    }
                }
            }
        }

        ans=new ArrayList<>();
        if(map.containsKey(endWord)){
            List<String>seq= new ArrayList<>();
            seq.add(endWord);
            dfs(endWord,seq);
        }
        return ans;

    }
    void dfs(String word, List<String>seq){
        if(word.equals(b)){
            List<String> dup= new ArrayList<>(seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }
        int steps=map.get(word);
        int size=word.length();
        for(int i=0; i<size; i++){
            for(char ch='a'; ch<='z'; ch++){
                char rA[]=word.toCharArray();
                rA[i]=ch;
                String newWord= new String(rA);
                if(map.containsKey(newWord)&&map.get(newWord)+1==steps){
                    seq.add(newWord);
                    dfs(newWord,seq);
                    seq.remove(seq.size()-1);
                }
            }
        }
    }
}





// --> Not for Leedcode

// class Solution {
//     public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//         HashSet<String> set= new HashSet<>();
//         int len=wordList.size();
//         for(int i=0; i<len; i++) set.add(wordList.get(i));
        
//         Queue<List<String>> q= new LinkedList<>();
//         List<String>ls= new ArrayList<>();
//         ls.add(beginWord);
//         q.add(ls);
        
//         List<String> usedOnLevel = new ArrayList<>();
//         usedOnLevel.add(beginWord);
        
//         int level=0;
        
//         List<List<String>> ans= new ArrayList<>();
        
//         while(!q.isEmpty()){
//             List<String> vec= q.peek();
//             q.remove();
        
//             if(vec.size()>level){
//                 level++;
//                 for(String it: usedOnLevel){
//                     set.remove(it);
//                 }
//             }
        
//             String word=vec.get(vec.size()-1);
//             if(word.equals(endWord)){
//                 if(ans.size()==0){
//                     ans.add(vec);
//                 }
//                 else if(ans.get(0).size()==vec.size()){
//                     ans.add(vec);
//                 }
//             }

//             for(int i=0; i<word.length(); i++){
//                 for(char ch='a'; ch<='z'; ch++){
//                     char rA[]= word.toCharArray();
//                     rA[i]=ch;
//                     String newWord= new String(rA);
//                     if(set.contains(newWord)){
//                         vec.add(newWord);
//                         List<String>temp= new ArrayList<>(vec);
//                         q.add(temp);
//                         usedOnLevel.add(newWord);
//                         vec.remove(vec.size()-1);
//                     }
//                 }
//             }
//         }
//         return ans;
//     }
// }
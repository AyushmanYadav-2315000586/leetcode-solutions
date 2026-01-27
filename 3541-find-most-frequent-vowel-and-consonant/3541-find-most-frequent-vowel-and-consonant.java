class Solution {
    public int maxFreqSum(String s) {
        Set <Character> set= Set.of('a','e','i','o','u');
        Map<Character,Integer> vowel= new HashMap<>();
        Map<Character,Integer> cons= new HashMap<>();

        for(char ch: s.toCharArray()){
            if(set.contains(ch)){
                vowel.put(ch,vowel.getOrDefault(ch,0)+1);
            }
            else{    
                cons.put(ch,cons.getOrDefault(ch,0)+1);
            }
        }

        int maxV=0;
        for(int freq: vowel.values()){
            maxV=Math.max(maxV,freq);
        }

        int maxC=0;
        for(int freq: cons.values()){
            maxC=Math.max(maxC,freq);
        }
        return maxV+maxC;
    }
}
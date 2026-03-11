class Solution {
    public int beautySum(String s) {
        int sum=0;
        for(int i=0; i<s.length(); i++){
            int []freq= new int[26];
            for(int j=i; j<s.length(); j++){
                freq[s.charAt(j)-'a']++;
                int b=getMax(freq)-getMin(freq);
                sum+=b;
            }
        }
        return sum;
    }
    int getMax(int[]freq){
        int max=0;
        for(int i=0; i<26; i++){
            max=Math.max(max,freq[i]);
        }
        return max;
    }
    int getMin(int[]freq){
        int min=Integer.MAX_VALUE;
        for(int i=0; i<26; i++){
            if(freq[i]!=0){
                min=Math.min(min,freq[i]);
            }
        }
        return min;
    }
}
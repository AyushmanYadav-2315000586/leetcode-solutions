class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list= new ArrayList<>();
        int []pCount= new int [26];
        int []sCount= new int [26];

        int b=p.length();
        for(int i=0; i<b; i++){
            pCount[p.charAt(i)-'a']++;
        }

        for(int i=0; i<s.length(); i++){
            sCount[s.charAt(i)-'a']++;
            if(i>=b){
                sCount[s.charAt(i-b)-'a']--;
            }
            if(Arrays.equals(sCount,pCount)){
                list.add(i-b+1);
            }
        }
        return list;

    }
}
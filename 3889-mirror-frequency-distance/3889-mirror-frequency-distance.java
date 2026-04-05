class Solution {
    public int mirrorFrequency(String s) {
        HashMap<Character,Integer> mapC= new HashMap<>();
        int n=s.length();

        for(int i=0; i<n; i++){
            mapC.put(s.charAt(i),mapC.getOrDefault(s.charAt(i),0)+1);
        }

        HashSet<Character> set= new HashSet<>();
        int ans=0;
        for(char c: mapC.keySet()){
            if(set.contains(c)) continue;

            char mirr='\0';

            if(c>='a' && c<='z'){
                mirr=(char)('a'+('z'-c));
            }else{
                mirr=(char)('0'+('9'-c));
            }
            int n1=mapC.get(c);
            int n2=mapC.getOrDefault(mirr,0);
        
            ans+=Math.abs(n1-n2);

            set.add(c);
            set.add(mirr);
        }

        return ans;

        
        
    }
}
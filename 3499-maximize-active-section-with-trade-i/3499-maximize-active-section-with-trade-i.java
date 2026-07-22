class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        ArrayList<Integer> list= new ArrayList<>();

        int cnt=0;
        int c2=0;
        for(char ch: s.toCharArray()){
            if(ch=='1') cnt++;
            
            if(ch=='0')c2++;

            else{
                if(c2>0){
                    list.add(c2);
                }
                c2=0;
            }
        }
        if(s.charAt(s.length()-1)=='0')
    list.add(c2);
        int maxCnt=0;
        for(int i=0; i<list.size()-1; i++){
            maxCnt=Math.max(maxCnt,list.get(i)+list.get(i+1));
        }
        return maxCnt+cnt;
    }
}
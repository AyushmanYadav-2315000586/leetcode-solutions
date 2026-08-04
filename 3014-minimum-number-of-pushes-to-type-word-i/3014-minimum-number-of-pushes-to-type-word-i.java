class Solution {
    public int minimumPushes(String word) {
        HashMap<Integer,Integer> map= new HashMap<>();
        int as=2;
        int res=0;
        for(char ch: word.toCharArray()){
            if(as>9){
                as=2;
            }

            map.put(as,map.getOrDefault(as,0)+1);
            res+=map.get(as);
            as++;
        }
        return res;
    }
}
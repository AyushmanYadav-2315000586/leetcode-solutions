class Solution {
    public List<Integer> findGoodIntegers(int n) {
        List<Integer> list= new ArrayList<>();

        int end=(int)Math.cbrt(n);
        HashMap<Integer,Integer> map= new HashMap<>();
        
        for(int i=1; i<=end; i++){
            for(int j=1; j<=end; j++){
                int sum=(i*i*i)+(j*j*j);

                if(sum>n){
                    break;
                }
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }

        for(Map.Entry<Integer,Integer> val: map.entrySet()){
            if(val.getValue()>2){
                list.add(val.getKey());
            }
        }

        Collections.sort(list);
        return list;
    }
}
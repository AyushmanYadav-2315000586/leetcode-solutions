class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0;
        int store=0;
        int total=0;
        for(int i=0; i<gas.length; i++){
            int diff=gas[i]-cost[i];
            total+=diff;
            store+=diff;
            if(store<0){
                store=0;
                start=i+1;
            }
        }
        return total>=0?start:-1;
    }
}
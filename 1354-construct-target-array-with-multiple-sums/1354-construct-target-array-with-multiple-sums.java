class Solution {
    public boolean isPossible(int[] nums) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        
        long ts=0;

        for(int num:nums){
            pq.add(num);
            ts+=num;
        }

        while(true){
            int max=pq.poll();
            long rS=ts-max;

            if(max==1||rS==1){
                return true;
            }

            if(rS==0 || max<=rS){
                return false;
            }

            long prev=max%rS;
            if(prev==0){
                return false;
            }
            ts=rS+prev;
            pq.add((int)prev);
        }
    }
}
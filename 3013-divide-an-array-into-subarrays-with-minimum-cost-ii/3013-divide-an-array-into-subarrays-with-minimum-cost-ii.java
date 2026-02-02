class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n=nums.length;

        TreeSet<int[]> min= new TreeSet<>((a,b)->{
            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });

        TreeSet<int[]> remaining= new TreeSet<>((a,b)->{
            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });

        long sum=0;

        int i=1;
        while(i<n&&i-dist<1){
            int []curr= new int []{nums[i],i};
            min.add(curr);
            sum+=nums[i];
            if(min.size()>k-1){
                int []largest=min.pollLast();
                sum-=largest[0];
                remaining.add(largest);
            }
            i++;
        }

        long result=Long.MAX_VALUE;
        while(i<n){
            int []curr =new int []{nums[i],i};
            min.add(curr);
            sum+=nums[i];
            if(min.size()>k-1){
                int largest[]=min.pollLast();
                sum-=largest[0];
                remaining.add(largest);
            }
        result=Math.min(sum,result);
        int remIdx=i-dist;
        int toRemove[]= new int[]{nums[remIdx],remIdx};
        if(min.remove(toRemove)){
            sum-=nums[remIdx];
            if(!remaining.isEmpty()){
                int[]promote=remaining.pollFirst();
                min.add(promote);
                sum+=promote[0];
            }
        }
        else{
            remaining.remove(toRemove);
        }
        i++;
    }
    return nums[0]+result;
    }

}
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans= new ArrayList<>();
        Queue<Integer> q= new LinkedList();
        for(int i=1; i<=8; i++){
            q.add(i);
        }
        while(!q.isEmpty()){
            int num=q.poll();
            if(num>=low && num<=high){
                ans.add(num);
            }
            int mod=num%10;
            if(mod==9){
                continue;
            }
            int newNum=(num*10)+mod+1;
            if(newNum>high){
                continue;
            }
            else{
                q.add(newNum);
            }
        }

        return ans;

    }
}
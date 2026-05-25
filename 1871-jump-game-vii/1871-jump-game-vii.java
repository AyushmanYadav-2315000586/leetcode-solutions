class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n=s.length();
        if(s.charAt(n-1)!='0'){
            return false;
        }
        Queue<Integer> q=new LinkedList<>();
        boolean vis[]= new boolean[n];

        q.add(0);
        vis[0]=true;
        int far=1;

        while(!q.isEmpty()){
            int pop=q.poll();
            if(pop==n-1){
                return true;
            }

            for(int i=Math.max(pop+minJump,far); i<=Math.min(pop+maxJump,n-1); i++){
                if(s.charAt(i)=='0' && !vis[i]){
                    q.add(i);
                    vis[i]=true;
                }
                far=i+1;
            }
        }
        return false;

    }
}
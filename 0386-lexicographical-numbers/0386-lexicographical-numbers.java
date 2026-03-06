class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res= new ArrayList<>();
        for(int i=1; i<=9; i++){
            solve(i,n,res);
        }
        return res;
    }
    void solve(int i, int n, List<Integer>res){
        if(i>n){
            return;
        }
        res.add(i);
        for(int j=0; j<=9; j++){
            int num=i*10+j;
            if(num>n) return;
            solve(num,n,res);
        }
    }
}
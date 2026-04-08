class Solution {
    public List<String> buildArray(int[] target, int n) {
        int st=1;
        List<String> res= new ArrayList<>();

        int i=0;

        while(i<target.length && st<=n){
            res.add("Push");

            if(target[i]==st){
                i++;
            }
            else{
                res.add("Pop");
            }
            st++;
        }
        return res;
    }
}
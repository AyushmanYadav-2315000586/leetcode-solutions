class Solution {
    public String getHappyString(int n, int k) {
        StringBuilder curr=new StringBuilder();
        String []res={""};
        int cnt[]= {0};
        solve(n,curr,cnt,k,res);
        return res[0];
    }
    void solve(int n, StringBuilder curr,int []cnt, int k, String[] res){
        if(curr.length()==n){
            cnt[0]++;
            if(cnt[0]==k){
                res[0]=curr.toString();
            }
            return;
        }

        for(char ch='a'; ch<='c'; ch++){
            if(curr.length()>0&&curr.charAt(curr.length()-1)==ch){
                continue;
            }

            curr.append(ch);
            solve(n,curr,cnt, k,res);
            if(!res[0].isEmpty()) return;
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
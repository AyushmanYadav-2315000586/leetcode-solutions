class Solution {
    public int longestBalanced(String s) {
        int n=s.length();

        int maxL=0;

        for(int i=0; i<n; i++){
            int []freq= new int [26];
            for(int j=i; j<n; j++){
                freq[s.charAt(j)-'a']++;
                if(checkBalance(freq)){
                    maxL=Math.max(maxL,j-i+1);
                }
            }
        }
        return maxL;
    }

    boolean checkBalance(int []freq){
        int common=0;

        for(int i=0; i<freq.length; i++){
            if(freq[i]==0) continue;

            if(common==0){
                common=freq[i];
            }
            else if(common!=freq[i]){
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        String ans="";
        int n=s.length();
        int charInSection=2*(numRows-1);
        for(int currRow=0; currRow<numRows; currRow++){
            int idx=currRow;
            while(idx<n){
                ans+=s.charAt(idx);
                if(currRow!=0 && currRow!=numRows-1){
                    int charInBetween=charInSection-2*(currRow);
                    int secondIndex=idx+charInBetween;
                    if(secondIndex<n){
                        ans+=s.charAt(secondIndex);
                    }
                }
                idx+=charInSection;
            }
        }
        return ans;
    }
}
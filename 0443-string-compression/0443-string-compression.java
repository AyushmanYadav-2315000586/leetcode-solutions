class Solution {
    public int compress(char[] chars) {
        StringBuilder str= new StringBuilder();
        int cnt=1;

        for(int i=1; i<chars.length; i++){
            if(chars[i]==chars[i-1]){
                cnt++;
            }
            else{
                str.append(chars[i-1]);
                if(cnt>1){
                    str.append(cnt);
                }
                cnt=1;
            }
        }
        str.append(chars[chars.length-1]);
        if(cnt>1){
            str.append(cnt);
        }

        for(int i=0; i<str.length();i++){
            chars[i]=str.charAt(i);
        }
        return str.length();

    }
}
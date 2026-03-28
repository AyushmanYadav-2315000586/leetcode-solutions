class Solution{
    public boolean checkLCP(String w,int[][] l){
        int n=w.length();
        for(int i=0;i<n;i++){
            if(w.charAt(i)!=w.charAt(n-1)){
                if(l[i][n-1]!=0)return false;
            }else{
                if(l[i][n-1]!=1)return false;
            }
        }
        for(int j=0;j<n;j++){
            if(w.charAt(n-1)!=w.charAt(j)){
                if(l[n-1][j]!=0)return false;
            }else{
                if(l[n-1][j]!=1)return false;
            }
        }
        for(int i=n-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                if(w.charAt(i)==w.charAt(j)){
                    if(l[i][j]!=1+l[i+1][j+1])return false;
                }else{
                    if(l[i][j]!=0)return false;
                }
            }
        }
        return true;
    }

    public String findTheString(int[][] l){
        int n=l.length;
        char[] w=new char[n];
        for(int i=0;i<n;i++)w[i]='$';

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(l[j][i]!=0){
                    w[i]=w[j];
                    break;
                }
            }
            if(w[i]=='$'){
                boolean[] f=new boolean[26];
                for(int j=0;j<i;j++){
                    if(l[j][i]==0){
                        f[w[j]-'a']=true;
                    }
                }
                for(int k=0;k<26;k++){
                    if(!f[k]){
                        w[i]=(char)('a'+k);
                        break;
                    }
                }
                if(w[i]=='$')return "";
            }
        }
        String r=new String(w);
        return checkLCP(r,l)?r:"";
    }
}
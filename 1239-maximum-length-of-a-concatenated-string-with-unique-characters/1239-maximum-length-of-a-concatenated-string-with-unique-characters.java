class Solution {
    public int maxLength(List<String> arr) {
        String temp="";
        int n=arr.size();
        return solve(0,arr,temp,n);
    }
    public int solve(int idx, List<String> arr, String temp, int n){
        if(idx>=n){
            return temp.length();
        }
        int include=0,exclude=0;
        if(hasDup(temp,arr.get(idx))){
            exclude=solve(idx+1, arr, temp,n);
        }
        else{
            exclude=solve(idx+1, arr, temp, n);
            include=solve(idx+1,arr,temp+arr.get(idx),n);
        }
        return Math.max(exclude, include);
    }
    public boolean hasDup(String temp, String s){
        int arr[]= new int[26];
        for(char ch : temp.toCharArray()){
            if(arr[ch-'a']>0){
                return true;
            }
            arr[ch-'a']++;
        }
        for(char ch: s.toCharArray()){
            if(arr[ch-'a']>0){
                return true;
            }
            arr[ch-'a']++;
        }
        return false;
    }
}
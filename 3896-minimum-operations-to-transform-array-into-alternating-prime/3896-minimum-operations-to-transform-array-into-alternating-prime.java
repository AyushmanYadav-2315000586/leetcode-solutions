class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int cnt=0;
        for(int i=0; i<n; i++){
            if(i%2==0){
                if(!isPrime(nums[i])){
                    int val=nextPrime(nums[i]);
                    cnt+=val-nums[i];
                    nums[i]=val;
                }
            }
            else{
                while(isPrime(nums[i])){
                    nums[i]=nums[i]+1;
                    cnt++;
                }
            }
        }
        return cnt;
    }
    boolean isPrime(int num){
        if(num<=1) return false;
        if(num==2) return true;

        if(num%2==0) return false;

        for(int i=3; i*i<=num; i+=2){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    int nextPrime(int num){

        if(num<=2) return 2;
        while(true){
            if(num%2==0){
                num++;
                continue;
            }
            if(isPrime(num)){
                return num;
            }
            num++;
        }
    }
}
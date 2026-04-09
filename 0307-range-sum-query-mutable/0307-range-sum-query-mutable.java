class NumArray {

    int[]nums;
    int[]blocks;
    int n;
    int blockSize;

    public NumArray(int[] nums) {
        this.nums=nums;
        n=nums.length;
        blockSize=(int)Math.ceil(Math.sqrt(n));
        blocks=new int[blockSize];
        for(int i=0; i<n; i++){
            int bI=i/blockSize;
            blocks[bI]+=nums[i];
        }
    }
    
    public void update(int index, int val) {
        int bI=index/blockSize;

        blocks[bI]-=nums[index];
        blocks[bI]+=val;
        nums[index]=val;
    }
    
    public int sumRange(int left, int right) {
        int sum=0;

        int sB=left/blockSize;
        int eB=right/blockSize;

        if(sB==eB){
            for(int i=left; i<=right; i++){
                sum+=nums[i];
            }
            return sum;
        }
        
        int eSB=((sB+1)*blockSize)-1;

        for(int i=left; i<=eSB; i++){
            sum+=nums[i];
        }

        for(int b=sB+1; b<=eB-1; b++){
            sum+=blocks[b];
        }

        int sEB=eB*blockSize;

        for(int i=sEB; i<=right; i++){
            sum+=nums[i];
        }
         return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
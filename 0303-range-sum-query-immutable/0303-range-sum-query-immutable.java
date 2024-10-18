class NumArray {

    int[] preSum;

    public NumArray(int[] nums) {
        this.preSum=nums;
        for(int i=0;i<nums.length;i++){
                if(i==0){
                    preSum[i]=nums[i];
                }else{
                    preSum[i]=nums[i]+preSum[i-1];
                }
                
        }
    }
    
    public int sumRange(int left, int right) {
        
        if(left==0){
                return preSum[right];
        }
        
        return preSum[right]-preSum[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
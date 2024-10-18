class NumArray {

    int[] preSum;

    public NumArray(int[] nums) {
        this.preSum=nums;
        for(int i=1;i<nums.length;i++){
             preSum[i]=(i==0)?nums[0]:nums[i]+preSum[i-1];
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
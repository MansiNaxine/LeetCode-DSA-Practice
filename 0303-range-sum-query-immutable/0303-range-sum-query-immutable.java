class NumArray {

    int[] preSum;

    public NumArray(int[] nums) {
        this.preSum=nums;
        preSum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
             preSum[i]=nums[i]+preSum[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        
        return left==0?preSum[right]:preSum[right]-preSum[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
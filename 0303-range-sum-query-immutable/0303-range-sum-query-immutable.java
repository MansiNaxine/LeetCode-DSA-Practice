class NumArray {

    int[] nums;

    public NumArray(int[] nums) {
        this.nums=nums;
    }
    
    public int sumRange(int left, int right) {

        int sum1=0;
        int preSum[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
                sum1 +=nums[i];
                preSum[i]=sum1;
        }
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
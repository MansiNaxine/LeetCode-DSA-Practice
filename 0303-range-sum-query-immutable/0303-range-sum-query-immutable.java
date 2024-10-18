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

        int sum2=0;
        int sufSum[]=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
                sum2 +=nums[i];
                sufSum[i]=sum2;
        }

        int totalSum=0;
        for(int i=0;i<nums.length;i++){
            totalSum +=nums[i];
        }

        if(left==0){
                return preSum[right];
        }

        if(right==nums.length-1){
            return sufSum[left];
        }
        
        return totalSum-(preSum[left-1]+sufSum[right+1]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
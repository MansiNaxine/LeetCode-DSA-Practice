class Solution {
    public int pivotIndex(int[] nums) {

        int n= nums.length;
        int leftSum = 0;
        int rightSum = -1;

        for(int  i = 0; i < n; i++) {
            rightSum = findSum(i + 1, nums);
            if(leftSum == rightSum) {
                return i;
            } else {
                leftSum += nums[i];
            }
        }

        return rightSum == 0 ? -1 : rightSum;
        
    }

    public int findSum(int index, int[] nums) {
        int sum = 0;
        for(int i = index; i < nums.length; i++) {
            sum += nums[i];
        }

        return sum;
    }
}
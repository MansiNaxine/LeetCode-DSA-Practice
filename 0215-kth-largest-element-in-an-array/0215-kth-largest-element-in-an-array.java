class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        //solve by using quick sort
        int n = nums.length;
        return quickSort(nums, n-k, 0, n-1);
    }

    public int quickSort(int[] nums, int index, int start, int end) {

        //base case
        if(start >= end) {
            return nums[start];
        }
        //recursive case
        int k = pivot(nums, start, end);

        if(k == index) {
            return nums[k];
        } else if (k > index) {
            return quickSort(nums, index, start, k - 1);
        } else {
            return quickSort(nums, index, k + 1, end);
        }

    }

    public int pivot(int[] nums, int start, int end) {

        int pivotEle = nums[end];
        int i = start;

        for(int j = start; j <= end-1; j++) {
            if(nums[j] < pivotEle) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
            }
        } 

        int temp = nums[end];
        nums[end] = nums[i];
        nums[i] = temp;

        return i;
    }
}
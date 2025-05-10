class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSort(nums, n - k, 0, n-1);
        
    }

    public int quickSort(int[] nums, int index, int start, int end) {
        
        //base index
        if(start == end) {
            return nums[start];
        }

        //recursive case
        int k = pivot(nums, start, end);

        if(k == index) {
            return nums[k];
        } else if (k < index) {
            return quickSort(nums, index, k + 1, end);
        } else {
            return quickSort(nums, index, start, k - 1);
        }
    }


    public int pivot(int[] nums, int start, int end) {

        int pivot = nums[end];
        int  i = start;

        for(int j = start; j <= end-1; j++) {
            if(nums[j] < pivot) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;

                i++;
            }
        }

        int temp = nums[i];
        nums[i] = nums[end];
        nums[end] = temp;


        return i;
    }
}
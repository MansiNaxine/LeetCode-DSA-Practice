class Solution {
    public void nextPermutation(int[] nums) {

        int n = nums.length;
        int j = n - 2;
        // int small = -1;
        // int jIndex = -1;

        //First fine the element which is less than the next element from end
        while(j >= 0) {
            if(nums[j] < nums[j + 1]) {
                // small = nums[j];
                // jIndex = j;
                break;
            }
            j -= 1;
        }

        int i = j + 1;
        // int nextGreater = -1;

        //find the next greater element than small

        while(i < n && j >= 0 && nums[i] > nums[j]) {
            i += 1;
        }

        //swap both small and nextGreater element
        if(i > 0) {
            int temp = nums[i - 1];
            nums[i - 1] = nums[j];
            nums[j] = temp;
        }

        if((n - j) > 1) {
            swap(nums, j + 1, n - 1);
        }
    }

    public void swap(int[] nums, int start, int end) {

        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
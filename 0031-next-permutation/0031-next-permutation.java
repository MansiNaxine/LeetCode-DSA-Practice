class Solution {
    public void nextPermutation(int[] nums) {

        //Total time complexity will take :- O(2n)
        //Space Complexity will be :- O(1)
        int n = nums.length;
        int j = n - 2;

        //First fine the element which is less than the next element from end
        //Time Complexity :- O(n)
        while(j >= 0) {
            if(nums[j] < nums[j + 1]) {
                break;
            }
            j -= 1;
        }

        int i = j + 1;

        //find the next greater element than small
        //Time Complexity :- by combining both above step and below step will tale O(n)
        while(i < n && j >= 0 && nums[i] > nums[j]) {
            i += 1;
        }

        //swap both small and nextGreater element
        //Time Complexity :- O(1)
        if(i > 0) {
            int temp = nums[i - 1];
            nums[i - 1] = nums[j];
            nums[j] = temp;
        }

        //Time Complexity :- O(n)
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
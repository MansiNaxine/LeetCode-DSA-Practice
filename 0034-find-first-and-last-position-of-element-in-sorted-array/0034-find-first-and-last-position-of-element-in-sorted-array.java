class Solution {
    public int[] searchRange(int[] nums, int target) {

        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int firstOccur = -1;
        int lastOccur = -1;

        //to find first occurrence
        while(start <= end) {

            int mid = (start + end)/2;

            if (nums[mid] <= target) {
                lastOccur = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        //to find last occurrence
        start = 0;
        end = n - 1;

        while(start <= end) {

            int mid = (start + end)/2;

            if (nums[mid] >= target) {
                firstOccur = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        firstOccur = (firstOccur != -1 && nums[firstOccur] == target) ? firstOccur : -1;
        lastOccur = (lastOccur != -1 && nums[lastOccur] == target) ? lastOccur : -1;

        return new int[]{firstOccur, lastOccur};

    }
}
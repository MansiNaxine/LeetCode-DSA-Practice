class Solution {
    public int[] searchRange(int[] nums, int target) {

        int n = nums.length;
        int firstOccu = findFirstOccurence(nums, target);
        int secondOccu = -1;
        if(firstOccu != -1) {
            secondOccu = findSecondOccurence(nums, target);
        }
        else {
            return new int[]{-1, -1};
        }

        return new int[]{firstOccu, secondOccu};
    }

    public int findFirstOccurence(int[] nums, int target) {

        int ans = -1;
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        while(start <= end) {

            int mid = (start + end) /2;

            if (nums[mid] >= target) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        if(ans >= 0 && nums[ans] != target) return -1;
        return ans;
    }

    public int findSecondOccurence(int[] nums, int target) {

        int ans = -1;
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        while(start <= end) {

            int mid = (start + end) /2;

            if (nums[mid] <= target) {
                ans = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        if(ans >= 0 && nums[ans] != target) return -1;
        return ans;
    }
}
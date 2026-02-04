class Solution {
    public int splitArray(int[] nums, int k) {

        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        //Edge case
        if(k == n) return max;

        int start = max;
        int end = sum;
        int ans = -1;

        while(start <= end) {

            int mid = (start + end)/2;
            int possibleSplit = getNoOfSubArrays(nums, mid);

            if (possibleSplit <= k) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public int getNoOfSubArrays(int[] nums, int mid) {

        int sum = 0;
        int count = 1;

        for(int num : nums) {
            if((num + sum) <= mid) {
                sum += num;
            }
            else {
                count += 1;
                sum = num;
            }
        }

        return count;
    }
}
class Solution {
    public int splitArray(int[] nums, int k) {

        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        int start = max;
        int end = sum;
        int ans = max;

        //Edge Case
        if(k == 1) return sum;
        else if(k == n) return max;

        while(start <= end) {

            int mid = (start + end) /2;
            int possibleDivision = getPossibleDivision(mid, nums);

            if(possibleDivision <= k) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return ans;
        
    }

    public int getPossibleDivision(int mid, int[] nums) {

        int cnt = 0;
        int sum = 0;

        for(int num :  nums) {
            if((sum + num) <= mid) {
                sum += num;
            }
            else {
                cnt += 1;
                sum = num;
            }
        }

        return cnt + 1;
    }
}
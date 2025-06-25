class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int sum = 0;
        int answer = Integer.MAX_VALUE;
        int n = nums.length;

        int j = 0;
        int i = 0;

        while(j < n) {
            sum += nums[j];

            while(i <=j && sum >= target) {
                answer = Math.min(answer, j - i + 1);
                sum -= nums[i];
                i++;
            }

            j++;
        }

        return answer == Integer.MAX_VALUE ? 0 : answer;
        
    }
}
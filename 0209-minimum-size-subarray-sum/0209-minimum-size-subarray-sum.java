class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;
        int sum = 0;
        int answer = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        while(j < n) {

            sum += nums[j];

            while(i <= j && sum >= target) {

                answer = Math.min(answer, j-i+1);
                sum -= nums[i];
                i++;
            }

            j++;
        }

        answer = answer > 1000000000 ? 0 : answer;

        return answer;
        
    }
}
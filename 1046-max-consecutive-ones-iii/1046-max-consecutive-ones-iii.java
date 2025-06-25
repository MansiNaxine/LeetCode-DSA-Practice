class Solution {
    public int longestOnes(int[] nums, int k) {

        int answer = 0;
        int zero = 0;
        int sum = 0;

        int i = 0;
        int j = 0;
        int n = nums.length;

        while(j < n) {
            sum += 1;

            if(nums[j] == 0) {
                zero++;
            }

            while(i <=j && zero > k) {
                sum -= 1;
                if(nums[i] == 0) {
                    zero--;
                }
                i++;
            }

            answer = Math.max(answer, j - i + 1);

            j++;
        }

        return answer;
        
    }
}
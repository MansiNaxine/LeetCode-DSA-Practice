class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int count = 0;
        int answer = 0;
        for(int num : nums) {
            count = (num == 0) ? 0 :  (count += 1);
            answer = Math.max(answer, count);
        }
        
        return answer;
    }
}
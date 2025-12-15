class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int count = 0;
        int answer = 0;
        for(int num : nums) {
            if(num == 0) {
                answer = Math.max(answer, count);
                count = 0;
            } else {
                count++;
            }
        }
        
        return Math.max(answer, count);
    }
}
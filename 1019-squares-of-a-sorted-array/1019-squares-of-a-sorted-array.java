class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int i = 0;
        int n = nums.length;
        int j = n - 1;
        int index = n - 1;
        int answer[] = new int[n];

        while(i <= j) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                answer[index] = nums[i] * nums[i];
                i++;
            } else {
                answer[index] = nums[j] * nums[j];
                j--;
            }
            index--;
        }

        return answer;
    }
}
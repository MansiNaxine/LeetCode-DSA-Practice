class Solution {
    public int[] sortedSquares(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];

        int i = 0; 
        int j = n - 1;
        int index = n - 1;

        while(i <= j) {
           if(Math.abs(nums[i]) < Math.abs(nums[j])) {
            answer[index] = nums[j] * nums[j];
            j--;
           } else {
            answer[index] = nums[i] * nums[i];
            i++;
           }

           index--;
        }

        return answer;
        
    }
}
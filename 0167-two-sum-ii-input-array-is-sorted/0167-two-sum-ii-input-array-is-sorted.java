class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        for(int i = 0 ; i < numbers.length ; i++) {
            int second = target - numbers[i];

            for(int j = i + 1 ; j < numbers.length ; j++) {
                if(second == numbers[j]) {
                    return new int[]{i+1, j+1};
                }
            }
        }

        return new int[]{0,0};
    }
}
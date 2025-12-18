class Solution {
    public int majorityElement(int[] nums) {

        //BruteForceApproach 
        //Time Complexity :-  O(n^2)
        //Space Complexity :-  O(1)

        int count = 1;
        int element = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if (nums[i] == element) {
                count++;
            }
            else if(count == 0) {
                element = nums[i];
                count = 1;
            }
            else {
                count--;
            }
        }

        int occurence = nums.length/2;
        count = 0;
        for(int num :  nums) {
            if(element == num) count++;
        }

        if(count > occurence) return element;

        return element;
        
    }
}
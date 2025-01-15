class Solution {
    public int majorityElement(int[] nums) {

        int count = 0;
        int majElement = 0;

        for(int i=0; i<nums.length; i++) {
            if(count == 0) {
                count = 1;
                majElement = nums[i];
            } else {
                if(majElement != nums[i]) {
                    count--;
                } else {
                    count++;
                }
            }
        }
        
        return majElement;
    }
}
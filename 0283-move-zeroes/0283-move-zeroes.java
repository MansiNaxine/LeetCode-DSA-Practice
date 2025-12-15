class Solution {
    public void moveZeroes(int[] nums) {
        
        //BruteForce Approach
        //Time Complexity :- O(2N)
        //Space Complexity :- O(No. of non zero elements)
        int n = nums.length;
        // List<Integer> list = new ArrayList<>();

        // for(int num : nums) {
        //     if(num != 0) list.add(num);
        // }

        // int index = 0;
        // for(int i = 0; i < n; i++) {
        //     if(i > (list.size() -  1)) nums[i] = 0;
        //     else {
        //         nums[i] = list.get(index);
        //         index++;
        //     }
        // }

        //Optimal Approach
        //Time Complexity :- O(N)
        //Space Complexity :- O(1)
        int i = 0;
        int j = 0;
        //Basically it is not a good practice to alter the array data, so please check with interviewer before doing this if he is okay with this
        while(i < n && j < n) {
            if(nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }

        while(i < n) {
            nums[i] = 0;
            i++;
        }
    }
}
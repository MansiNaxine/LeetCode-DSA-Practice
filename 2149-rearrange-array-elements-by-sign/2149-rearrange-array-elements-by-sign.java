class Solution {
    public int[] rearrangeArray(int[] nums) {
        //Time Complexity :- O(2N)
        //Space Complexity :- O(n)
        //return bruteForaceAprroach(nums);

        //Time Complexity :- O(N)
        //Space Complexity :- O(N)
        return optimalApproach(nums);
    }

    public int[] optimalApproach(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];
        int pos = 0;
        int neg = 1;

        for(int num : nums) {
            if (num > 0) {
                answer[pos] = num;
                pos += 2;
            }
            else {
                answer[neg] = num;
                neg += 2;
            }
        }

        return answer;
    }

    public int[] bruteForaceAprroach(int[] nums){
        int n = nums.length;
        int pos[] = new int[n/2];
        int neg[] = new int[n/2];

        int posI = 0;
        int negI = 0;

        //For adding elemnts to +ve and -ve Arrays
        for(int num : nums) {
            if (num < 0) {
                neg[negI] = num;
                negI++;
            } 
            else {
                pos[posI] = num;
                posI++;
            }
        }

        posI = 0;
        negI = 0;
        int index = 0;

        while(index < n) {
            if ((index % 2) == 0) {
                nums[index] = pos[posI];
                posI++;
            }
            else {
                nums[index] = neg[negI];
                negI++;
            }

            index++;
        }


        return nums;

    }
}
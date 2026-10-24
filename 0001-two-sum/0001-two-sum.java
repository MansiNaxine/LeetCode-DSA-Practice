class Solution {
    public int[] twoSum(int[] nums, int target) {
        // for storing answer
        int[] ans = new int[2];
        ans[0] = -100000;
        ans[1] = -100000;
        int n = nums.length;
        int[] originArr = new int[nums.length];

        for(int i = 0; i < n; i++) {
            originArr[i] = nums[i];
        }

        //Logic
        //first sort the array
        Arrays.sort(nums);

        int i = 0;
        int j = n - 1;

        while(i < j) {

            if(nums[i] + nums[j] < target) i++;
            else if (nums[i] + nums[j] > target) j--;
            else {
                ans[0] = i;
                ans[1] = j;
                break;
            }
        }
        
        int first = -100000;
        int second = -100000;
        for(int k = 0 ; k < n; k++) {
            if(originArr[k] == nums[ans[0]] && first == -100000) first = k;
            else if(originArr[k] == nums[ans[1]] && second == -100000) second = k;
        }

        ans[0] = first;
        ans[1] = second;
        return ans;
    }
}
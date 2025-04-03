class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        //first I will sort the array
        Arrays.sort(nums);

        //first form the answer list
        List<List<Integer>> answer = new ArrayList<>();
        int i = 0;
        int n = nums.length;

        while(i < n) {
            int currentI = nums[i];
            int findSecondNum = -nums[i];
            int j = i + 1;
            int k = n - 1;

            //binary search to find the second number which is negative of current I
            while(j < k) {
                int sum = nums[j] + nums[k];
                if(sum == findSecondNum) {
                    List<Integer> currentList = new ArrayList<>();
                    //adding all nums of I, J, K
                    currentList.add(nums[i]);
                    currentList.add(nums[j]);
                    currentList.add(nums[k]);

                    while(j < n && nums[j] == currentList.get(1)) {
                        j++;
                    }

                    while(k >=0 && nums[k] == currentList.get(2)) {
                        k--;
                    }

                    answer.add(new ArrayList<>(currentList));
                } else if(sum < findSecondNum) {
                    j++;
                } else {
                    k--;
                }
            }

            while(i < n && nums[i] == currentI) {
                i++;
            }
        }

        return answer;
    }
}
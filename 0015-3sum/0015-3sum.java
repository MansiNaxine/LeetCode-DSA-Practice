class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        int i = 0;
        int n = nums.length;

        while(i < n) {
            int target = -nums[i];
            int duplicateI = nums[i];
            int j = i + 1;
            int k = n - 1;

            while(j < k) {
                if(nums[j] + nums[k] == target) {

                    List<Integer> currSeq = new ArrayList<>();
                        currSeq.add(nums[i]);
                        currSeq.add(nums[j]);
                        currSeq.add(nums[k]);

                        answer.add(new ArrayList<>(currSeq));

                        while (j < n && nums[j] == currSeq.get(1)){
                            j++;
                        }

                        while (k > j && nums[k] == currSeq.get(2)) {
                            k--;
                        }

                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }

            while(i < n && nums[i] == duplicateI) {
                i++;
            }
        }
        
        return answer;
    }
}
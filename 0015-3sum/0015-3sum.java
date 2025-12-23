class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        int i = 0; 
        int n = nums.length;
        
        while(i < n) {
            int currI = nums[i];
            int target = -nums[i];
            int j = i + 1;
            int k = n - 1;

            while(j < k) {
                int sum = nums[j] + nums[k];
                if(sum == target) {
                    List<Integer> currSeq = new ArrayList<>();
                    currSeq.add(nums[i]);
                    currSeq.add(nums[j]);
                    currSeq.add(nums[k]);

                    answer.add(new ArrayList<>(currSeq));
                    int currJ = nums[j];
                    int newJ = j + 1;
                    while(newJ < k && nums[newJ] == currJ) {
                        newJ++;
                    }
                    j = newJ;
                    
                    int currK = nums[k];
                    int newK = k - 1;
                    while(newK > j && nums[newK] == currK) {
                        newK--;
                    }
                    k = newK;
                }
                else if (sum < target) {
                    j++;
                }
                else {
                    k--;
                }
            }

            int newIndex = i + 1;
            while(newIndex < n && nums[newIndex] == currI) {
                newIndex++;
            }
            i = newIndex;
        }

        return answer;
        
    }
}
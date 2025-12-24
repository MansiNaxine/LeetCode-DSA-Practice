class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        if(target == Integer.MIN_VALUE || target == Integer.MAX_VALUE) return answer;

        int i = 0;
        int n = nums.length;

        while(i < n) {
            int j = i + 1;
            while(j < n) {
                long searchNum = (long) target - ((long)nums[i] + (long)nums[j]);
                int k = j + 1;
                int l = n - 1;
                while(k < l) {
                    long sum = (long) nums[k] + (long) nums[l];
                    if (sum < searchNum) {
                        k++;
                    }
                    else if (sum > searchNum) {
                        l--;
                    }
                    else {
                        List<Integer> currSeq = new ArrayList<>();
                        currSeq.add(nums[i]);
                        currSeq.add(nums[j]);
                        currSeq.add(nums[k]);
                        currSeq.add(nums[l]);

                        answer.add(new ArrayList<>(currSeq));

                        k++;
                        l--;

                        while(k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }

                        while(k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    }
                }

                j++;
                while(j < n && nums[j] == nums[j - 1]) {
                    j++;
                }
            }

            i++;
            while(i < n && nums[i] == nums[i - 1]) {
                i++;
            }
        }

        return answer;
    }
}
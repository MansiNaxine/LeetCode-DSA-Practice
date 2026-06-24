class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        ArrayList<Integer> answer = new ArrayList<>();
        
        modifiedTabulation(nums, n, answer);
        
        int len = answer.size();
        
        for(int i = 0; i < len/2; i++) {
            int temp = answer.get(i);
            answer.set(i, answer.get(len - i - 1)) ;
            answer.set(len - i - 1, temp) ;
        }
        return answer;
    }

    public void modifiedTabulation(int[] nums, int n, ArrayList<Integer> answer) {
        int[] dp = new int[n];
        int[] hash = new int[n];
        
        for(int i = 0; i < n; i++) {
          hash[i] = i;  
        }
        
        Arrays.fill(dp, 1);
        int maxAns = 0;
        int lastIndex = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(1 + dp[j] > dp[i] && nums[i]%nums[j] == 0) {
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
            
            if(dp[i] > maxAns) {
                maxAns = Math.max(maxAns, dp[i]);
                lastIndex = i;
            }
        }
        
        answer.add(nums[lastIndex]);
        
        while(lastIndex != hash[lastIndex]) {
            lastIndex = hash[lastIndex];
            answer.add(nums[lastIndex]);
        }
    }
}
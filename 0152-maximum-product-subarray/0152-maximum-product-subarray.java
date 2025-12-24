class Solution {
    public int maxProduct(int[] nums) {

        int n = nums.length;
        int pref = 1;
        int suf = 1;
        int answer = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            if(pref == 0) pref = 1;
            if(suf == 0) suf = 1;

            pref *= nums[i];
            suf *= nums[n - i - 1];

            answer = Math.max(answer, Math.max(pref, suf));
        }

        return answer;
        
    }
}
class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int prefixSum[] = new int[n];
        int suffixSum[] = new int[n];
        int sum = 0;

        for(int i = 0; i < n ; i++ ) {
            sum += nums[i];
            prefixSum[i] = sum;
        }
        
        sum = 0;
        for(int j = n - 1; j >= 0; j--) {
            sum += nums[j];
            suffixSum[j] = sum;
        }

        int i = 0; 
        int j = 0;
        while(i < n && j < n) {
            if(prefixSum[i] == suffixSum[j]) {
                return i;
            }
            i++;
            j++;
        }

        return -1;
    }
}
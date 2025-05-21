class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        int n = nums.length;
        int start = 1;
        int end = Arrays.stream(nums).max().getAsInt();
        int answer = 0;

        while(start <= end) {
            int mid = (start + end)/2;
            if (isPossible(mid, nums, threshold)) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return answer;
        
    }

    public boolean isPossible(int mid, int[] nums, int key) {

        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(sum > key) break;
            
            if(nums[i] <= mid) {
                sum += 1;
            } else if(nums[i] % mid == 0) {
                sum += nums[i]/mid;
            } else {
                sum += nums[i]/mid + 1;
            }
        }

        return sum <= key;
        
    }
}
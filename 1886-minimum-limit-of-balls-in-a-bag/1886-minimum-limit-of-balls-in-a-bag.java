class Solution {
    public int minimumSize(int[] nums, int maxOperations) {

        int n = nums.length;
        
        int start = 1;
        int end = Arrays.stream(nums).max().getAsInt();
        int answer = end;

        while(start <= end) {
            int mid = (start + end)/2;
            if(isPossible(nums, mid, maxOperations)){
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return answer;
    }

    public boolean isPossible(int[] nums, int mid, int key) {
        int count = 0 ;
        for(int i = 0; i < nums.length; i++) {

            if(count > key) break;

            if(nums[i] <= mid) {
                continue;
            } else if (nums[i]%mid == 0) {
                count += (nums[i]/mid) - 1;
            } else {
                count += (nums[i]/mid);
            }
        }

        return count <= key;
    }
}
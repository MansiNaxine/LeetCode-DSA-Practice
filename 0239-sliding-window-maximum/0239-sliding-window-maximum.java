class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        // return bruteForceApproach(nums, k);

        return optimalApproach(nums, k);
        
    }

    public int[] optimalApproach(int[] nums, int k) {

        int n = nums.length;
        Deque<Integer> deq = new LinkedList<>();
        int[] ans = new int[n - k + 1];
        int index = 0;
        //we have to maintain window and also we have to store the max values in a decreasing oreder
        int i = 0;

        while(i < n) {
            //first maintain the window
            if(!deq.isEmpty() && deq.peekFirst() <= i - k) deq.removeFirst();

            //store the max values in a decreasing order
            while(!deq.isEmpty() && nums[i] >= nums[deq.peekLast()]) {
                deq.removeLast();
            }

            //insert the latest element index in deq
            deq.addLast(i);

            //add the max element to answer
            if(i >= k - 1) {
                ans[index] = nums[deq.peekFirst()];
                index++;
            }

            i++;
        }

        return ans;
    }

    //This will give TLE with O(N^2) time complexity
    public int[] bruteForceApproach(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for(int i = 0; i <= n - k; i++) {
            int max = nums[i];
            for(int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            ans[i] = max;
        }

        return ans;
    }
}
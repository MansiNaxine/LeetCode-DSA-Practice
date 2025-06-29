class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        Deque<Integer> q = new LinkedList<>();
        List<Integer> arr = new ArrayList<>();

        //first will iterate till k size window, and will find out the maximum element
        int i = 0; 
        while(i < k) {
            while(!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                q.removeLast();
            }
            q.addLast(i);
            i++;
        }

        while(i < n) {
            arr.add(nums[q.peekFirst()]);

            //loop for out of window index
            while(!q.isEmpty() && q.peekFirst() <= i - k) {
                q.removeFirst();
            }

            //checking for next Greater Element
            while(!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                q.removeLast();
            }

            q.addLast(i);
            i++;
        }

        arr.add(nums[q.peekFirst()]);

        int[] answer = new int[arr.size()];
        for(int j = 0; j < arr.size(); j++) {
            answer[j] = arr.get(j);
        }

        return answer;
        
    }
}
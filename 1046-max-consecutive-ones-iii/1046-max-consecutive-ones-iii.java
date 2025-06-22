class Solution {
    public int longestOnes(int[] nums, int k) {

        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int zero = 0;

        for(int i = 0; i < nums.length; i++) {

            q.add(nums[i]);
            if(nums[i] == 0) {
                zero++;
            }

            while(zero > k && !q.isEmpty()) {

                if(q.peek() == 0) {
                    zero--;
                }
                q.remove();
            }

            answer = Math.max(answer, q.size());
        }

        return answer;
        
    }
}
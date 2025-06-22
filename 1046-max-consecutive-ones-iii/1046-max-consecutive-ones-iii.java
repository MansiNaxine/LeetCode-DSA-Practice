class Solution {
    public int longestOnes(int[] nums, int k) {

        int answer = 0;
        //Deque<Integer> q = new LinkedList<>();
        int zero = 0;

        // for(int i = 0; i < nums.length; i++) {

        //     q.addLast(nums[i]);
        //     if(nums[i] == 0) {
        //         zero++;
        //     }

        //     while(zero > k && !q.isEmpty()) {

        //         if(q.peekFirst() == 0) {
        //             zero--;
        //         }
        //         q.removeFirst();
        //     }

        //     answer = Math.max(answer, q.size());
        // }

        //with optimized space complexity
    int i = 0; 
    int j = 0;
    int n = nums.length;

    while(j < n) {
       
        if(nums[j] == 0) {
            zero++;
        }

        while(i <= j && zero > k) {
            if(nums[i] == 0) {
                zero--;
            }
            i++;
        }
         
        int len = j - i + 1;
        answer = Math.max(answer, len);
        
        j++;
    }
        return answer;
        
    }
}
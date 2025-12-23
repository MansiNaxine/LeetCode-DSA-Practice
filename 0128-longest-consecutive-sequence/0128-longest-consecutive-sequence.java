class Solution {
    public int longestConsecutive(int[] nums) {
        
        //will take Map
        Set<Integer> set = new HashSet();

        for(int num :  nums) {
           set.add(num);
        }

        int answer = 1;

        for(int num :  set) {
            int count = 1;
            if(!set.contains(num - 1)) {
                while(set.contains(num + 1)) {
                    count += 1;
                    num += 1;
                }
                answer = Math.max(answer, count);
            }
        }

        return nums.length == 0 ? 0 : answer;


    }
}
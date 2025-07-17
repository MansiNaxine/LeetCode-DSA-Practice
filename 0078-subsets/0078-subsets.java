class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        int n = nums.length;
        List<List<Integer>> answer = new ArrayList<>();

        int len = (int) Math.pow(2, n);

        for(int i = 0; i < len; i++) {
            List<Integer> arr = new ArrayList<>();

            int index = 0;
            int numIn = i;
            while(numIn > 0) {
                int num = numIn % 2;
                if(num == 1) arr.add(nums[index]);
                numIn /= 2;
                index++;
            }

            answer.add(new ArrayList<>(arr));
        }

        return answer;
        
    }
}
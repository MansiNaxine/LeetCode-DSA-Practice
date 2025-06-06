class Solution {
    public String largestNumber(int[] nums) {
        
        ArrayList<String> answer = new ArrayList<>();
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            answer.add(Integer.toString(nums[i]));
        }

        Collections.sort(answer, (x, y) -> {
            String X = x + y;
            String Y = y + x;

            return Y.compareTo(X);
        });

        StringBuilder str = new StringBuilder();

        for(int i = 0; i < answer.size(); i++) {
            str.append(answer.get(i));
        }

        int i = 0; 
        while(i < n && str.charAt(i) == '0') {
            i++;
        }

        if (i == n) {
            return "0";
        } else {
            return str.toString();
        }

    }
}
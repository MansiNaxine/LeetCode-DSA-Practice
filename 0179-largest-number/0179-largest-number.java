class Solution {
    public String largestNumber(int[] nums) {
        
        //use custom comparator
        //we need list for comparator
        ArrayList<String> arr = new ArrayList<>();
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            arr.add(Integer.toString(nums[i]));
        }

        //we will sort if Y > X
        Collections.sort(arr, (x, y) -> {
            String X = x + y;
            String Y = y + x;

            return Y.compareTo(X);
        });

        StringBuilder str = new StringBuilder();
        for(int i = 0; i < arr.size(); i++) {
            str.append(arr.get(i));
        }

        int i = 0; 
        while(i < n && str.charAt(i) == '0') {
            i++;
        }

        if(i == n) {
            return "0";
        } else {
            return str.toString();
        }

    }
}
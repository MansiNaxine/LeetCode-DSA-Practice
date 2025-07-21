class Solution {
    public int[] sortByBits(int[] arr) {    
        Arrays.sort(arr);
        List<List<Integer>> answer = new ArrayList<>();
        
        int n = arr.length;
        

        for(int i = 0; i < n; i++) {
            int original = arr[i];
            int num = original;
            int count = 0;
            while(num > 0) {
                int ans = num%2;
                if(ans == 1) count++;
                num /= 2;
            }

            // List<Integer> curr = new ArrayList<>();
            // curr.add(original);
            // if (count >= 0 && count < answer.size()) {
            //     answer.get(count).add(new ArrayList<>(curr));
            // }

            while(answer.size() <= count) {
                answer.add(new ArrayList<>());
            }

            answer.get(count).add(original);

        }

        int k = 0;
        int[] answerArr = new int[n];

        for(int i = 0; i < answer.size(); i++) {
            for(int j = 0; j < answer.get(i).size(); j++) {
                answerArr[k] = answer.get(i).get(j);
                k++;
            }
        }
        

        return answerArr;
    }
}
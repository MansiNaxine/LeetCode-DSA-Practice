class Solution {

    public int sumFourDivisors(int[] nums) {
        int n = nums.length;
        int N = nums[0];
        int max = nums[0];
        for(int i = 0; i < n; i++) {
            max = Math.max(max,nums[i]);
        }

        N = max + 1;
        int div[] = new int[N];
        int sumDiv[] = new int[N];


        for(int i = 1; i < N; i++) {
            for(int j = i; j < N; j+=i) {
                div[j]++;
                sumDiv[j] += i ;
            }
        }

        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(div[nums[i]] == 4) {
                answer += sumDiv[nums[i]];
            }
        }

        return answer;
        
    }
}
class Solution {

    public int sumFourDivisors(int[] nums) {
        int n = nums.length;
        int N = nums[0];// rather than iterating till 100001 we can calculate maximum
        int max = nums[0];

        //Calculate maximum to get the size for div and sunDiv array
        for(int i = 0; i < n; i++) {
            max = Math.max(max,nums[i]);
        }

        N = max + 1;
        int div[] = new int[N];
        int sumDiv[] = new int[N];

        //Sieve of eranthosis
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
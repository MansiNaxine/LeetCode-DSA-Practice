class Solution {
    public int candy(int[] ratings) {
       
       int n = ratings.length;
       int[] pre = new int[n];
       int[] suf = new int[n];
       int cnt = 1;
       pre[0] = 1;

       //for prefix calculation
       for(int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i-1]) cnt += 1;
            else cnt = 1;
            pre[i] = cnt;
        }

        cnt = 1;
        suf[n - 1] = cnt;
        //for suffix Calculation
        for(int i = n - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1]) cnt += 1;
            else cnt = 1;
            suf[i] = cnt;
        }

        //Calculate answer
        int answer = 0;
        for(int i = 0; i < n; i++) {
            answer += Math.max(pre[i], suf[i]);
        }


        return answer;
    }

}
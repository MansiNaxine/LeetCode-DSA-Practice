class Solution {
    public int candy(int[] ratings) {
       
       int n = ratings.length;
       int[] pre = new int[n];
       int[] suf = new int[n];
       int cnt1 = 1;
       pre[0] = 1;
       int cnt2 = 1;
       suf[n - 1] = cnt2;
       
       for(int i = 1; i < n; i++) {
            //for prefix calculation
            if(ratings[i] > ratings[i-1]) cnt1 += 1;
            else cnt1 = 1;
            pre[i] = cnt1;
            //for suffix Calculation
            if(ratings[n - i - 1] > ratings[(n - i - 1) + 1]) cnt2 += 1;
            else cnt2 = 1;
            suf[n - i - 1] = cnt2;
        }

        //Calculate answer
        int answer = 0;
        for(int i = 0; i < n; i++) {
            answer += Math.max(pre[i], suf[i]);
        }


        return answer;
    }

}
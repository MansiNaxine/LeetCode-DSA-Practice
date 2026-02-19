class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int n = cardPoints.length;
        int left = 0;
        int right = 0;
        int lI = 0;
        

        while(lI < k) {
            left += cardPoints[lI];
            lI++;
        }

        int maxPoints = left;

        //Some Edge cases
        if(k == 1) return Math.max(cardPoints[0] , cardPoints[n - 1]);
        if(k == n) return left;
        int len = n - k - 1;
        for(int i = n - 1; i > len; i--) {
            right += cardPoints[i];
            lI -= 1;
            if(lI >= 0) left -= cardPoints[lI];
            maxPoints = Math.max(maxPoints, left + right);

        }

        return maxPoints;
    }
}
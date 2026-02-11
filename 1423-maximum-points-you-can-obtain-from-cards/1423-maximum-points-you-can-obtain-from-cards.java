class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;
        //first travel from 0 till kth elements and calculate the maxScore
        int maxScore = 0;
        int leftSum = 0;
        int rightSum = 0;
        int lIn = -1;

        for(int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
            lIn += 1;
        }
        
        //Boundry Case
        if(k == n) return leftSum;

        maxScore = leftSum;
        int rIn = n - 1;
        for(int i = lIn ; i >= 0; i--) {
            leftSum = leftSum - cardPoints[i];
            rightSum = rightSum + cardPoints[rIn];
            rIn--;

            maxScore = Math.max(maxScore, (leftSum + rightSum));
        }
        

        return maxScore;
    }
}
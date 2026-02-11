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

        if(k == n) return leftSum;

        maxScore = leftSum;


        //Now travel from K to N-1 elements by using sliding window approach and calculate the sum accordingly
        // for(int i = n - 1; i > k ; i--) {
        //     rightSum += cardPoints[i];
        //     leftSum -=  cardPoints[lIn];
            
        //     // lIn -= 1;
        //     maxScore = Math.max(maxScore, (rightSum + leftSum));
        // }
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
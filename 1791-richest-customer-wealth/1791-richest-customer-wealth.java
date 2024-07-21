class Solution {
    public int maximumWealth(int[][] accounts) {
        int max=Integer.MIN_VALUE;
        for(int[] per:accounts){
            int rowSum=0;
            for(int acc:per){
                rowSum +=acc;
            }
            if(max<rowSum){
                max=rowSum;
            }
        }
        return max;
        
    }
}
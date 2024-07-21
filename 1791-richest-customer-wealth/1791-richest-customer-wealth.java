class Solution {
    public int maximumWealth(int[][] accounts) {
        int max=Integer.MIN_VALUE;
        for(int per=0;per<accounts.length;per++){
            int rowSum=0;
            for(int acc=0;acc<accounts[per].length;acc++){
                rowSum +=accounts[per][acc];
            }
            if(max<rowSum){
                max=rowSum;
            }
        }
        return max;
        
    }
}
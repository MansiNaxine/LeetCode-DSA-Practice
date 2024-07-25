class Solution {
    public int arrangeCoins(int n) {
        long start=0;
        long end=n;
        while(start<=end){
            long mid=start+(end-start)/2;

            long coinsUsed=mid*(mid+1)/2;

            if(coinsUsed==n){
                return (int)mid;
            }else if(coinsUsed<n){
                start=mid+1;
            }else{
                end=mid-1;
            }

        }

        return (int)end;
        
    }
}
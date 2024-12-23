class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        long n = piles.length;
        long max = 0;

        for(int i = 0 ; i < n ; i++){
            max = Math.max(max, piles[i]);
        }

        long start = 1;
        long end = max;
        long answer = 0;

        while(start <= end){   
            long mid = (start + end)/2;

            if(isPossible(piles,mid,n,h)){
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
       
      return (int)answer;         
    }

    public boolean isPossible(int[] piles, long mid, long n, long h){

        long answer = 0;
         for(int i = 0; i < n ; i++){
  
            if (piles[i] < (int)mid) {
                answer +=1;
            }
            if (piles[i] >= (int)mid) {

                if(piles[i] % (int)mid == 0 ){

                    answer += piles[i] / (int)mid;
                } else {
                    answer += (piles[i] / (int)mid + 1);
                }
            }
        }

        return (answer <= h);
    }
}
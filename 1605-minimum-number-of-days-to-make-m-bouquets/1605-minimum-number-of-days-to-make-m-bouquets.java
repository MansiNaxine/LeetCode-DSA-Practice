class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        
        long n = bloomDay.length;
        long start = 1;
        long end = Arrays.stream(bloomDay).max().getAsInt();

        long answer = end;
        long mNew = m;
        long kNew = k;

        if(n < (mNew * kNew))  {
            answer = -1;
        }

        while(start <= end) {
            long mid = (start + end) / 2;
            if(isPossible(mid, bloomDay, m, k)) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return (int)answer;
    }

    public boolean isPossible(long mid, int[] nums, int m, int k) {

        long bouqueCount = 0;
        long check = k;
        for(int i = 0 ; i < nums.length; i++) {
            if(nums[i] <= (int)mid) {
                if((int)check > 0) {
                    check--;
                }
                if((int)check == 0) {
                    bouqueCount++;
                    check = k;
                }
            } else if(nums[i] > mid && (int)check != k){
               if(k <= nums.length - i) {
                    check = k;
                    continue;
                } else {
                    break;
                }
            }
        }

        return (int)bouqueCount >= m;
    }
}
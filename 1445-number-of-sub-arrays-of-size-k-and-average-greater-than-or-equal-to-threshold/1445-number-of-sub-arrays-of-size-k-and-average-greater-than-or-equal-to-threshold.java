class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int n = arr.length;
        int i = 0;
        int avg = 0;
        int answer = 0;
        while(i < k) {
            avg += arr[i];
            i++;
        }

        if(avg/k >= threshold) {
            answer++;
        }

        
        while(i < n) {
            avg += arr[i];
            avg -= arr[i - k];

            if(avg/k >= threshold) {
                answer++;
            }

            i++;
        }
        
        return answer;
    }
}
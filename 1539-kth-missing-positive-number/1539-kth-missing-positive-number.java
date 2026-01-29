class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        // return bruteForceApproach(arr, k);

        return optimalApproachUsingBS(arr, k);
        
    }

    public int optimalApproachUsingBS(int[] arr, int k) {

        int n = arr.length;
        int start = 0;
        int end = n - 1;

        while(start <= end) {

            int mid = (start + end)/2;
            int missingNum = arr[mid] - (mid + 1);

            if(missingNum < k) {
                start = mid + 1;
            }
            else {
                end= mid - 1;
            }
        }

        return end + 1 + k;
    }

    public int bruteForceApproach(int[] arr, int k) {

        for(int num : arr) {
            if(num <= k) k++;
            else break;
        }

        return k;
    }
}
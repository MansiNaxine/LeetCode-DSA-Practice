class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        // double answer = bruteForceApproach(nums1, nums2);
        double answer = optimalApproach(nums1, nums2);

        return answer;
    }

    public double optimalApproach(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int left = (n1 + n2 + 1)/2;
        if(n1 > n2) return optimalApproach(nums2, nums1);
        int low = 0;
        int high = n1;

        while(low <= high) {

            int m1 = (low + high)/2;
            int m2 = left - m1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if(m1 < n1) r1 = nums1[m1];
            if(m2 < n2) r2 = nums2[m2];
            if(m1 > 0) l1 = nums1[m1 - 1];
            if(m2 > 0) l2 = nums2[m2 - 1];

            if(l1 <= r2 && l2 <= r1) {
                if ((n % 2) == 1) {
                    return (double) Math.max(l1, l2);
                }
                else {
                    return (double) ((Math.max(l1, l2)) + (Math.min(r1, r2)))/2;
                }
            }
            else if (l1 > r2) {
                high = m1 - 1;
            }
            else {
                low = m1 + 1;
            }
        }

        return 0;

    }

    public double bruteForceApproach(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int ind1 = n/2 - 1;
        int ind2 = n/2;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        int arr[] = new int[n];
        int index = 0;

        while(i < n1 && j < n2) {
            if(nums1[i] < nums2[j]) {
                if(i == ind1) ele1 = nums1[i];
                if(i == ind2) ele2 = nums1[i];
                arr[index] = nums1[i];
                index++;
                i++;
            }
            else {
                if(j == ind1) ele1 = nums2[j];
                if(j == ind2) ele2 = nums2[j];
                arr[index] = nums2[j];
                index++;
                j++;
            }
        }

        while(i < n1) {
             if(i == ind1) ele1 = nums1[i];
             if(i == ind2) ele2 = nums1[i];
             arr[index] = nums1[i];
             index++;
             i++;
        }

        while(j < n2) {
            if(j == ind1) ele1 = nums2[j];
            if(j == ind2) ele2 = nums2[j];
            arr[index] = nums2[j];
            index++;
            j++;
        }

        if(n%2 == 1) {
            return arr[ind2];
        }

        return (double) (arr[ind2] + arr[ind1])/2;
    }
}
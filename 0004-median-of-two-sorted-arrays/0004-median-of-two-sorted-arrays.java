class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int m = nums2.length;
        if(m < n) return findMedianSortedArrays(nums2, nums1);

        int len = n + m;
        int median = (n + m + 1)/2;
        int start = 0;
        int end = n;

        while(start <= end) {

            int m1 = (start + end)/2;
            int m2 = median - m1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if(m1 != 0) l1 = nums1[m1 - 1];
            if(m2 != 0) l2 = nums2[m2 - 1];
            if(m1 != n) r1 = nums1[m1];
            if(m2 != m) r2 = nums2[m2];

            if((l1 <= r2) && (l2 <= r1)) {
                if(len%2 == 1) {
                    return Math.max(l1, l2);
                } else {
                    int left = Math.max(l1, l2);
                    int right = Math.min(r1, r2);
                    return (double) (left + right)/2;
                }
                    
            }
            else if (l2 > r1) {
                start = m1 + 1;
            }
            else {
                end = m1 - 1;
            }
        }

        return 0;

    }
}
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
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
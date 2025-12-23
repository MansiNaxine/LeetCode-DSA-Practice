class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //Optimal Solution
        //this is only to reduce space complexity
        firstOptimalSolution(nums1, m, nums2, n);

        //optimalSolutionUsingShellSort()
        optimalSolutionUsingShellSort(nums1, m, nums2, n);
        return;
        
    }

    public void optimalSolutionUsingShellSort(int[] nums1, int m, int[] nums2, int n) {

        int len = m + n;
        int gap = (len/2) + (len%2);

        while(gap > 0) {
            int left = 0;
            int right = gap + left;
            while(left < len && right < n) {
                //1st case will include arr1 and arr2
                if (left < m && right < n) {
                    swapElements(nums1, nums2, left, right);
                }
                else if (left >= m && right < n) { // both will present in 2nd array
                    swapElements(nums2, nums2, left, right);
                }
                else { //both will present in 1st array
                    swapElements(nums1, nums1, left, right);
                }
                left++;
                right++;
            }
            if(gap == 1) break;
            gap = (gap/2) + (gap%2);
        }
    }

    public void swapElements(int[] nums1, int[] nums2, int left, int right) {
        if(nums1[left] > nums2[right]) {
            int temp = nums1[left];
            nums1[left] = nums2[right];
            nums2[right] = temp;
        }
    }

    public void firstOptimalSolution(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = 0;

        while(i >= 0 && j < n) {
            if (nums1[i] > nums2[j]) {
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                i--;
                j++;
            } else {
                break;
            }
            
        }

        Arrays.sort(nums1, 0, m);
        Arrays.sort(nums2);

        //Copy all elements from nums2 to nums1
        int index = m ;
        for(int k = 0; k < n; k++) {
            nums1[index] = nums2[k];
            index++;
        }
    }
}
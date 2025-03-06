class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int l1 = nums1.length;
        int l2 = nums2.length;

        int i = 0;
        int j = 0;
        int answer[] = new int[m+n];
        int id = 0;

        while(i < m && j < n) {
            if(nums1[i] <= nums2[j]) {
                answer[id] = nums1[i];
                i++;
            } else {
                answer[id] = nums2[j];
                j++;
            }
            id++;
        }


        while(i < m) {
            answer[id] = nums1[i];
            i++;
            id++;
        }

        while(j < n) {
            answer[id] = nums2[j];
            j++;
            id++;
        }

        for(int k=0; k<answer.length; k++) {
            nums1[k] = answer[k];
        }
    }
}
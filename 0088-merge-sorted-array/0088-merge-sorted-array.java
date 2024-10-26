class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i=0;
        int j=0;
        int k=0;

        int ans[]=new int[nums1.length];

        while(i< m && j<n){
            if(nums1[i]<nums2[j]){
                ans[k]=nums1[i];
                i++;
            }else{
                ans[k]=nums2[j];
                j++;
            }
            k++;
        }

        while(i<m){
            ans[k]=nums1[i];
            k++;
            i++;
        }


        while(j<n){
            ans[k]=nums2[j];
            j++;
            k++;

        }

        for(int index=0;index<ans.length;index++){
            nums1[index]=ans[index];
        }
        
    }
}
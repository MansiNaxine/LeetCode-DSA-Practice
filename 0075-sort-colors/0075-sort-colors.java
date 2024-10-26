class Solution {
    public void sortColors(int[] nums) {


        int arr[]=new int[3];

        for(int i=0;i<nums.length;i++){
            arr[nums[i]]++;
        }
        
        int j=0;

         while(j<nums.length){
            while(j<arr[0]){
                nums[j]=0;
                j++;
            }

             while(j<arr[0]+arr[1]){
                nums[j]=1;
                j++;
            }
             while(j<arr[0]+arr[1]+arr[2]){
                nums[j]=2;
                j++;
            }
      }
        
    }
}
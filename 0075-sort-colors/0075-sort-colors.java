class Solution {
    public void sortColors(int[] nums) {


        int arr[]=new int[3];

        for(int i=0;i<nums.length;i++){
            arr[nums[i]]++;
        }

        int z=arr[0];
        int o=arr[1];
        int t=arr[2];
        int j=0;

         while(j<nums.length){
            while(z>0){
                nums[j]=0;

                z--;
                j++;
            }

             while(o>0){
                nums[j]=1;
                o--;
                j++;
            }
             while(t>0){
                nums[j]=2;
                t--;
                j++;
            }
      }
        
    }
}
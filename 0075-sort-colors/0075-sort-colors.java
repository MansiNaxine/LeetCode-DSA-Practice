class Solution {
    public void sortColors(int[] nums) {


        int arr[]=new int[3];

        for(int i=0;i<nums.length;i++){
            arr[nums[i]]++;
        }

        int z=0;
        int j=0;

         while(j<nums.length){
            while(z<arr[0]){
                nums[j]=0;

                z++;
                j++;
            }

            int o=0;

             while(o<arr[1]){
                nums[j]=1;
                o++;
                j++;
            }
            
            int t=0;
             while(t<arr[2]){
                nums[j]=2;
                t++;
                j++;
            }
      }
        
    }
}
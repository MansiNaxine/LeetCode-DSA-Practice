class Solution {
    public int[] twoSum(int[] numbers, int target) {

        // for(int i=0;i<numbers.length;i++){
        //     for(int j=i+1;j<numbers.length;j++){
        //         if(numbers[i]+numbers[j]==target){
        //             return new int[]{i+1,j+1};
        //         }
        //     }
        // }

        int i=0;
        int j=numbers.length-1;


        while(i<=j){
            int sum=numbers[i]+numbers[j];
            if(sum==target){
                return new int[]{i+1,j+1};
            }else if(sum>target){
                j--;
            }else{
                i++;
            }
        }

        return new int[]{};
        
    }
}
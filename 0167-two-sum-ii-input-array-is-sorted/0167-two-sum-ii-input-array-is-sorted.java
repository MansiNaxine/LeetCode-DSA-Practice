class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        for(int i=0;i<numbers.length;i++){
            int s=i+1;
            int e=numbers.length-1;
            int temp=target-numbers[i];

            while(s<=e){
                int m=s+(e-s)/2;

                if(numbers[m]==temp && m!=i){
                    return new int[]{i+1,m+1};
                }else if(numbers[m]<temp){
                    s=m+1;
                }else{
                    e=m-1;
                }
            }
        }

        return new int[]{-1,-1};
    }
}
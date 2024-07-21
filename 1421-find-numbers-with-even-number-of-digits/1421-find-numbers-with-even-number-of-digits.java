class Solution {
    public int findNumbers(int[] nums) {
        int count=0;
        for(int num:nums){
            if(even(num)%2==0){
                count++;
            }
        } 
        return count; 
    }
    public int even(int num){
        int count=0;
        if(num<0){
            return num*-1;
        }
        if(num==0){
            return 1;
        }
        while(num>0){
            count++;
            num /=10;
        }
        return count;
    }
}
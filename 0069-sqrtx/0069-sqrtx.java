class Solution {
    public int mySqrt(int x) {

        //If we know the given variable is having value 0 and 1 then square root of these numbers are same
        if(x==0 || x==1){
            return x;
        }

        int start=1;
        int end=x;

        //we are iterating till the number and checking if square of mid is equal to or gretaer or smaller than given number
        while(start<=end){
            int  mid=start+(end-start)/2;

            if(x==mid*mid){
                return mid;
            }else if((long)x<(long)mid*mid){//if square of mid is less than the given number then obviously our end will be the answer
                    end=mid-1;
            }else{
                start=mid+1;
            }
        }

        return end ;
        
    }
}
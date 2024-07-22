class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start=0;
        int end=arr.length-1;


        while(start<end){
            int mid=start+(end-start)/2;

            if(arr[mid]> arr[mid+1]){
                //you are in descending part of array
                //this may be possibility that u r having an answer
                //check for left placed elements as well
                end=mid;
            }else{
                //you are in the ascending part of array
                start=mid+1;
            }
        }


        //in the end both start and end will point to the same element
        
        return start;
    }
}
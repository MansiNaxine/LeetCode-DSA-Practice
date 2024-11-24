class Solution {

    //Not a optimal Solution
    
    public int findKthLargest(int[] nums, int k) {

        int n = nums.length;
        int index = n - k;

        return quickSort(nums, 0, n-1, index);
    }

    public int quickSort(int[] nums, int start, int end, int index){

        if(start == end){
            return nums[start];
        }

        int k = partition(nums, start, end);

        if(k == index){

            return nums[index];

        }else if( k < index){

            return quickSort(nums, k+1, end, index);

        }else{

            return quickSort(nums, start, k-1, index);
        }
    }

    public int partition(int[] nums, int start, int end){

        int pivot = nums[end];

        int i = start;

        for(int j=start; j<=end-1; j++){

            if(nums[j] < pivot){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
            }
        }

        int temp = nums[i];
        nums[i] = nums[end];
        nums[end] = temp;

        return i;
    }
}
class Solution {
    public int[] sortArray(int[] nums) {
    
       int n = nums.length;
       mergeSort(nums, 0, n - 1);

       return nums;
        
    }

    public void mergeSort(int[] nums, int start, int end) {

        //base case
        if(start == end) {
            return;
        }

        //recursive case
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);

        merge(nums, start, mid, end);
    }

    public void merge(int[] nums, int start, int mid, int end) {

        int i = start;
        int j = mid + 1;

        ArrayList<Integer> answer = new ArrayList<>();

        while(i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                answer.add(nums[i]);
                i++;
            } else {
                answer.add(nums[j]);
                j++;
            }
        }

        while(i <= mid) {
            answer.add(nums[i]);
            i++;
        }

        while(j <= end) {
            answer.add(nums[j]);
            j++;
        }

        int index = 0;
        for(int k = start; k <= end ; k++) {
            nums[k] = answer.get(index);
            index++;
        }
    }
}
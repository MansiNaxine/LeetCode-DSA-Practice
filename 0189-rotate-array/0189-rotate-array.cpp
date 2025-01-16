class Solution {
public:
    void rotate(vector<int>& nums, int k) {

        int n = nums.size();
        k = k % n;

        //first -> reverse entire array
        reverse(nums, 0 , n-1);
        //second -> reverse array till k-1
        reverse(nums, 0 , k-1);
        //third -> reverse from k to end
        reverse(nums, k , n-1);
        
    }

    void reverse(vector<int>& nums , int start, int end) {

        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
};
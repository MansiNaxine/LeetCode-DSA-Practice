class NumArray {
public:

    vector<int> prefix;

    NumArray(vector<int>& nums) {
        int n = nums.size();
        prefix.resize(n, 0);
        int sum = 0; 

        for(int i=0; i<n; i++) {
            sum += nums[i];
            prefix[i] = sum;
        }
    }
    
    int sumRange(int left, int right) {
        
        if(left == 0) {
            return prefix[right];
        } else {
            return prefix[right] - prefix[left - 1];
        }
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * int param_1 = obj->sumRange(left,right);
 */
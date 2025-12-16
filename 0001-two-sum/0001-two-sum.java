import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int n = nums.length;
        int nums1[] = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums1);
        return calculateIndices(nums1, target, n, nums);
    }

    public int[] calculateIndices(int[] nums, int target, int n, int[] nums1) {
        
        int[] answer = new int[2];
        int i = 0;
        int j = n - 1;
        int a = -1;
        int b = -1;

        while(i < j) {
            int sum = nums[i] + nums[j] ;
            if(sum == target) {
                a = nums[i];
                b = nums[j];
                break;
            } 
            else if (sum < target) {
                i++;
            } 
            else {
                j--;
            }
        }

        int startI = -1;
        for(int k = 0; k < n; k++) {
            if(a == b) {
              if(nums1[k] == a) {
                if(startI < 0) {
                    startI = k;
                    answer[0] = startI;
                } else if (k != startI && startI != -1){
                    answer[1] = k;
                }
              }
            } 
            else if(nums1[k] == a) {
                answer[0] = k;
            }
            else if (nums1[k] == b) {
                answer[1] = k;
            }
        }

        return answer;

    }
}
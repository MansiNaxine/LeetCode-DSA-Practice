class Solution {
    public int trap(int[] height) {
        //    int n = height.length;
    //    int[] suffixMax = new int[n];
    //    suffixMax[n - 1] = height[n - 1];
    //    int rightMax = height[n - 1];


    //    for(int i = n - 2; i >= 0; i--) {
    //         if(height[i] > rightMax) {
    //             rightMax = height[i];
    //         }
    //         suffixMax[i] = rightMax;
    //    }

    //    int leftMax = height[0];
    //    int area = 0;

    //    for(int i = 1; i < n; i++) {
    //         int num = height[i];
    //         if(leftMax > num && suffixMax[i] > num) {
    //             area += Math.min(leftMax, suffixMax[i]) - height[i];
    //         }

    //         if(leftMax < num) leftMax = num;
    //    }

    //    return area;

    int n = height.length;
    int left = 0;
    int right = n - 1;
    int leftMax = 0;
    int rightMax = 0;
    int area = 0;

    while(left <= right) {
        if(leftMax <= rightMax) {

            if(leftMax > height[left]) area += leftMax - height[left];
            else leftMax = height[left];

            left += 1;
        }
        else {
            if(rightMax > height[right]) area += rightMax - height[right];
            else rightMax = height[right];

            right -= 1;
        }
    }

    return area;
    }
}
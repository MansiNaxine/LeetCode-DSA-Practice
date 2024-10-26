class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        //1:- Sort the array
        //2:- then iterate the array and calculate the sum=-nums[i]
        //3:- Check for the nums[j]+nums[k]==sum, then return i,j,k else j++,k--;
        //4:- Check not to include duplicates like nums[i],nums[j],nums[k], CALCULATE DISTINCT PAIRS

        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        int i=0;
        int n=nums.length;
        while(i<n){
            int target=-nums[i];
            int j=i+1;
            int k=n-1;
            int duplicateI=nums[i];

            while(j<k){
                if(nums[j]+nums[k]==target){
                    List<Integer> currentArr=new ArrayList<>();
                    currentArr.add(nums[i]);
                    currentArr.add(nums[j]);
                    currentArr.add(nums[k]);

                    list.add(new ArrayList<>(currentArr));

                    //Check for duplicates jth and kth elements
                    while(j<k && nums[j]==currentArr.get(1)){
                        j++;
                    }

                    while(k>j && nums[k]==currentArr.get(2)){
                        k--;
                    }
                }else if(nums[j]+nums[k]<target){
                    j++;
                }else{
                    k--;
                }
            }

            //Check for ith duplicate element
            while(i<n && duplicateI==nums[i]){
                i++;
            }

        }

        return list;
    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);

        List<List<Integer>> list=new ArrayList<>();
        
        int n=nums.length;

        int i=0;

        while(i<n){
            int target=-nums[i];
            int fixedI=nums[i];
            int j=i+1;
            int k=n-1;
            while(j<k){
                if(nums[j]+nums[k]==target){
                    List<Integer> currentArray=new ArrayList<>();
                    currentArray.add(nums[i]);
                    currentArray.add(nums[j]);
                    currentArray.add(nums[k]);

                    list.add(new ArrayList<Integer>(currentArray));

                    while(j<k && nums[j]==currentArray.get(1)){
                        j++;
                    }

                    while(k>j && nums[k]==currentArray.get(2)){
                        k--;
                    }

                }else if(nums[j]+nums[k]<target){
                    j++;
                }else{
                    k--;
                }
            }

            while(i<n && fixedI==nums[i]){
                i++;
            }

        }
        return list;
    }
}
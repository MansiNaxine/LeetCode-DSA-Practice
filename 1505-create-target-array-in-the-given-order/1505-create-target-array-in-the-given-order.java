class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n=nums.length;
        int target[]=new int[n];

        //more time complexity O(n+n*n);

        // for(int i=0;i<nums.length;i++){
        //     target[i]=-1;
        // }

        // int i=0;
        // while(i<nums.length){
        //     int k=n-1;
        //     int j=index[i];
        //     if(target[index[i]]==-1){
        //         target[index[i]]=nums[i];
        //     }else{
        //         if(j<i){
        //             while(k>j){
        //                 target[k]=target[k-1];
        //                 k--;
        //             }
        //         }
        //         target[index[i]]=nums[i];
        //     }
                

        //     i++;
        // }

        
        //with optimized solution
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(index[i],nums[i]);
        }

        for(int i=0;i<n;i++){
            target[i]=list.get(i);
        }

        return target;
        
    }
}
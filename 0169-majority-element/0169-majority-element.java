class Solution {

    public int majorityElement(int[] nums) {

        int n=nums.length/2;

        int ans=0;
        int count=0;

        // Map<Integer,Integer> map=new HashMap<>();

        // for(int num:nums){

        //     if(!map.containsKey(num)){
        //         map.put(num,1);
        //     }else{
        //         map.put(num,map.get(num)+1);
        //     }
        // }

        // for(Map.Entry<Integer,Integer> entry:map.entrySet()){
        //     if(entry.getValue()>n){
        //         ans=entry.getKey();
        //         break;
        //     }
        // }
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                ans=nums[i];
                count=1;
            }else{
                if(ans==nums[i]){
                    count++;
                }else{  
                        count--;
                    }
                 }
            }

        return ans;
        
    }
}
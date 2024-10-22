class Solution {

    public int majorityElement(int[] nums) {

        int n=nums.length/2;

        int ans=0;

        Map<Integer,Integer> map=new HashMap<>();

        for(int num:nums){

            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num,map.get(num)+1);
            }
        }

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>n){
                ans=entry.getKey();
                break;
            }
        }

        return ans;
        
    }
}
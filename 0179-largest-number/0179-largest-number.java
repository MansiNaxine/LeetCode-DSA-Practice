class Solution {
    public String largestNumber(int[] nums) {

        ArrayList<String> arr=new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            arr.add(Integer.toString(nums[i]));
        }

        Collections.sort(arr,(x,y)->{
            String X=x+y;
            String Y=y+x;

            return Y.compareTo(X);
        });

        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<nums.length;i++){
            sb.append(arr.get(i));
        }

        int i=0;
        while(i<nums.length && sb.charAt(i)=='0'){
            i++;
            
        }

        if(i==nums.length){
            return "0";
        }

        return sb.toString();
        
    }
}
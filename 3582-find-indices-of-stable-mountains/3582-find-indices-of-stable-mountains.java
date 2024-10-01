class Solution {
    public List<Integer> stableMountains(int[] height, int threshold) {

        List<Integer> list=new ArrayList<>();

        for(int i=0;i<height.length;i++){
            if(height[i]>threshold && i!=height.length-1){
                list.add(i+1);
            }
        }
        
        return list;
    }
}
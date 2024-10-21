class Solution {
    public int largestAltitude(int[] gain) {

        int roadTrip[]=new int[gain.length+1];
        
        int max=-1;
        int sum=0;
        roadTrip[0]=0;
        for(int i=0;i<gain.length;i++){
            sum +=gain[i];
            roadTrip[i+1]=sum;
        }
        
        for(int i=0;i<roadTrip.length;i++){
            max=Math.max(max,roadTrip[i]);
        }
        
        return max;
    }
}
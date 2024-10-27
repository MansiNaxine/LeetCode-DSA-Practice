class Solution {
    public int sumFourDivisors(int[] nums) {

        int N=100001;

        int divisor[]=new int[N];
        int sumDivisor[]=new int[N];

        for(int i=1;i<divisor.length;i++){
            for(int j=i;j<divisor.length;j +=i){
                divisor[j]++;
                sumDivisor[j] +=i;
            }

            
        }

        int ans=0;

        for(int i=0;i<nums.length;i++){
            if(divisor[nums[i]]==4){
                ans += sumDivisor[nums[i]];
            }
        }

        return ans;
        
    }
}
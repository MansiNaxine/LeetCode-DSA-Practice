class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        //BruteForce Approach will take O(n^2)
        //Directly jump onto Optimal Approach
        //We will use MOORE'S VOTING ALGORTIHM
        //Time Complexity :-  O(2n)
        //Space Complexity :- O(1)
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;
        List<Integer> answer = new ArrayList<>();

        for(int num : nums) {
            if(count1 == 0 && num != ele2) {
                count1 = 1;
                ele1 = num;
            }
            else if (count2 == 0 && num != ele1) {
                count2 = 1;
                ele2 = num;
            }
            else if(num == ele1 && num != ele2) {
                count1++;
            }
            else if(num == ele2 && num != ele1) {
                count2++;
            }
            else {
                count1--;
                count2--;
            }

        }

        count1 = 0;
        count2 = 0;
        int len = nums.length/3;

        for(int num :  nums) {
            if(num == ele1) count1++;
            else if(num == ele2) count2++;
        }

        if(count1 > len && count2 > len) {
            answer.add(ele1);
            answer.add(ele2);
        }
        else if(count1 > len) {
            answer.add(ele1);
        }
        else if (count2 > len) {
            answer.add(ele2);
        }
        
        return answer;

    }
}
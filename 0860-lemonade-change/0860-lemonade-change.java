class Solution {
    public boolean lemonadeChange(int[] bills) {

        // Arrays.sort(bills);
        int n = bills.length;
        int i = 0;
        int five = 0;
        int ten = 0;
    

        while(i < n) {
            if(bills[i] == 5) five += 1;
            else if (bills[i] == 10) {
                if(five > 0) {
                    ten += 1;
                    five -= 1;
                }
                else return false;
            }
            else {
                if(five > 0 && ten > 0) {
                    ten -= 1;
                    five -= 1;
                }
                else if (five >= 3) {
                    five -= 3;
                }
                else {
                    return false;
                }
            }
            i++;
        }

        return true;
        
    }
}
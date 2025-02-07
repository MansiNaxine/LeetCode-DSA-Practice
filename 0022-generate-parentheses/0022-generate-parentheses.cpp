class Solution {
public:

    vector<string> answer = {};
    vector<char> currentSeq = {};

    vector<string> generateParenthesis(int n) {

        recursion(0, 0, 2*n);
        return answer;
    }

    void recursion(int start, int sum, int L) {

        //base case
        if(start == L) {
            if(sum == 0) {

                string str = "";
                for(int i=0; i<currentSeq.size(); i++) {
                    str += currentSeq[i];
                }
                answer.push_back(str);
            }
            return;
        }

        //recursive case
        //1st for open paranthesis
        if(sum < L/2) {
            currentSeq.push_back('(');
            recursion(start+1, sum+1, L);
            currentSeq.pop_back();
        }
        

        //2nd for closing paranthesis
        if(sum > 0) {
            currentSeq.push_back(')');
            recursion(start+1, sum-1, L);
            currentSeq.pop_back();
        }

    }
};
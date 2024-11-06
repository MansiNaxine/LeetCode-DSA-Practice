class Solution {

    List<List<Integer>> list=new ArrayList<>();
    List<Integer> currSeq=new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        helper(candidates,target,0);
        return list;
        
    }

    public void helper(int[] candidates, int target,int index){

        if(target==0){
            list.add(new ArrayList<>(currSeq));
            return;
        }

        for(int i=index;i<candidates.length;i++){
            if(target>=candidates[i]){
                currSeq.add(candidates[i]);
                helper(candidates,target-candidates[i],i);
                currSeq.remove(currSeq.size()-1);
            }
        }
    }
}
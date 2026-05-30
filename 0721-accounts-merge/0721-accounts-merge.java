class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        int n = accounts.size();
        Map<String, Integer> map = new TreeMap<>();
        DisJoint unionObj = new DisJoint(n);

        for(int i = 0; i < n; i++) {
            for(int j = 1; j < accounts.get(i).size(); j++) {

                if(map.containsKey(accounts.get(i).get(j))) {
                    int index = map.get(accounts.get(i).get(j));
                    unionObj.formUnion(index, i);
                }
                else map.put(accounts.get(i).get(j), i);
            }
        }

        List<List<String>> answerList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < accounts.get(i).size(); j++) {
                List<String> currList = new ArrayList<>();
                currList.add(accounts.get(i).get(0));
                answerList.add(new ArrayList<>(currList));
                break;
            }

        }

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            int index = entry.getValue();
            int parentOfIndex = unionObj.findParent(index);
            if(index != parentOfIndex) {
                answerList.get(parentOfIndex).add(entry.getKey());
            }
            else answerList.get(index).add(entry.getKey());
        }

        List<List<String>> finalAnswer = new ArrayList<>();

        for(List<String> list : answerList) {
            if(list.size() > 1) {
                List<String> sortList = new ArrayList<>();
                for(int i = 1; i < list.size(); i++) {
                    sortList.add(list.get(i));
                }
                Collections.sort(sortList);
                List<String> currList = new ArrayList<>();
                currList.add(list.get(0));
                currList.addAll(sortList);
                finalAnswer.add(new ArrayList<>(currList));
            }
        }

        return finalAnswer;
    }
}

class DisJoint {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DisJoint(int len) {
        for(int i = 0; i <= len; i++) {
            size.add(1);
            parent.add(i);
        }
    }

    public int findParent(int node) {
        if(node == parent.get(node)) return node;
        return findParent(parent.get(node));
    }

    public void formUnion(int u, int v) {
        int parentU = findParent(u);
        int parentV = findParent(v);

        if(size.get(parentU) < size.get(parentV)) {
            parent.set(parentU, parentV);
            size.set(parentV, size.get(parentU) + size.get(parentV));
        }
        else {
            parent.set(parentV, parentU);
            size.set(parentU, size.get(parentU) + size.get(parentV));
        }
    }
}
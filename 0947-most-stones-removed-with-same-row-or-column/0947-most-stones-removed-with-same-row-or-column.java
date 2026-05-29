class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = Integer.MIN_VALUE;
        int maxCol = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        int row = maxRow + 1;
        int col = maxCol + 1;
        int len = row + col;

        DisJointUnion unionObj = new DisJointUnion(len);
        for(int i = 0; i < n; i++) {
            int u = stones[i][0];
            int v = stones[i][1] + row;

            if(unionObj.findUParent(u) != unionObj.findUParent(v)) {
                unionObj.formUnion(u, v);
            }
        }

        int count = 0;
        Set<Integer> parentList = new HashSet<>();

        for(int i = 0; i < len; i++) {
            if(unionObj.findUParent(i) != i) parentList.add(unionObj.findUParent(i));
        }

        for(int i = 0; i < len; i++) {
            if(unionObj.findUParent(i) == i && (parentList.contains(i))) count++;
        }

        return n - count;

    }
}

class DisJointUnion {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DisJointUnion(int len) {
        for(int i = 0; i <= len; i++) {
            size.add(1);
            parent.add(i);
        }
    }

    public int findUParent(int node) {
        if(node == parent.get(node)) return node;
        return findUParent(parent.get(node));
    }

    public void formUnion(int u, int v) {
        int parentU = findUParent(u);
        int parentV = findUParent(v);

        if(size.get(parentU) < size.get(parentV)) {
            parent.set(parentU, parentV);
            size.set(parentV, size.get(parentV) + size.get(parentU));
        }
        else {
            parent.set(parentV, parentU);
            size.set(parentU, size.get(parentV) + size.get(parentU)); 
        }
    }
}
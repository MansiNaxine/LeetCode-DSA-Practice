class Solution {
    public int makeConnected(int n, int[][] connections) {

        DisJointUnion unionObj = new DisJointUnion(n);
        int len = connections.length;
        int cnt = 0;

        for(int i = 0; i < len; i++) {
            int u = connections[i][0];
            int v = connections[i][1];

            if(unionObj.findUParent(u) == unionObj.findUParent(v)) cnt++;
            else unionObj.formUnion(u, v);
        }

        int parentIself = 0;
        for(int i = 0; i < n; i++) {
            if(unionObj.findUParent(i) == i) parentIself++;
        }

        return (parentIself - 1) <= cnt ? parentIself - 1 : -1;

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
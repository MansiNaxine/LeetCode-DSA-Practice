class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        
        int len =(m*n) - 1;
        DisJoint unionObj = new DisJoint(len);
        int newN = positions.length;

        int[][] newPosArr = new int[m][n];

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i < newN; i++) {
            int row = positions[i][0];
            int col = positions[i][1];
            if(newPosArr[row][col] == 1) {
                ans.add(cnt);
                continue;
            }
            cnt++;
            newPosArr[row][col] = 1;
            for(int j = 0 ; j < 4; j++) {
                    int newRow = row + delRow[j];
                    int newCol = col + delCol[j];
                    if(newRow < m && newRow >= 0 && newCol < n && newCol >= 0 && newPosArr[newRow][newCol] == 1) {
                        int u = (row * n) + col;
                        int v = (newRow * n) + newCol;
                        
                        if(unionObj.findParent(u) != unionObj.findParent(v)) {
                            cnt--;
                            unionObj.formUnion(u, v);
                        }
                    }
            }
            
            ans.add(cnt);
        }

        return ans;
        
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
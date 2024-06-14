class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards=new ArrayList<>();
        char[][] boards=new char[n][n];

        helper(boards,allBoards,0);
        return allBoards;
    }

    public void helper(char[][] board,List<List<String>> allBoards,int col){
        //BASE CASE
        if(col==board.length){
            saveBoard(board,allBoards);
                return;
            }

        for(int row=0;row<board.length;row++){
            if(isSafe(row,col,board)){
                //adding 'Q' IF true
                board[row][col]='Q';
                helper(board, allBoards,col+1);
                //removing 'Q' in the next position
                board[row][col]='.';
            }
        }
    }

    public void saveBoard(char[][] board,List<List<String>> allBoards){
        String row="";
        List<String> newBoard=new ArrayList<>();

        for(int i=0;i<board.length;i++){
            row="";
            for(int j=0;j<board.length;j++){
                if(board[i][j]=='Q'){
                    row +='Q';
                }else{
                    row +='.';
                }
            }
            newBoard.add(row);
        }
        allBoards.add(newBoard);
    }
    public boolean isSafe(int row,int col,char[][] board){

        //horizontal
        for(int j=0;j<board.length;j++){
            if(board[row][j]=='Q'){
                return false;
            }
        }

        //vertical
        for(int i=0;i<board.length;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        //upper left
        int r=row;
        for(int c=col;c>=0&&r>=0;c--,r--){
            if(board[r][c]=='Q'){
                return false;
            }
        }

        //upper right
        r=row;
        for(int c=col;c<board.length && r>=0;c++,r--){
           if(board[r][c]=='Q'){
                return false;
            } 
        }

        //lower left
        r=row;
        for(int c=col;c>=0&&r<board.length;c--,r++){
            if(board[r][c]=='Q'){
                return false;
            } 
        }

        //lower right
        r=row;
        for(int c=col;c<board.length && r<board.length;c++,r++){
            if(board[r][c]=='Q'){
                return false;
            } 
        }

        return true;
    }
    
}
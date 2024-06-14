class Solution {
    public List<List<String>> solveNQueens(int n) {
    List<List<String>> allBoards=new ArrayList<>();
    char[][] boards=new char[n][n];
    helper(boards,allBoards,0);
    
    return allBoards;
    }
    public void helper(char[][] boards,List<List<String>> allBoards,int col){

        //BASE CASE
        if(col==boards.length){
            saveBoard(boards,allBoards);
            return;
        }
        for(int row=0;row<boards.length;row++){
            if(isSafe(row,col,boards)){
                boards[row][col]='Q';
                helper(boards,allBoards,col+1);
                boards[row][col]='.';
            }
        }
    }
    public boolean isSafe(int row,int col,char[][] boards){

        //HORIZONTAL LINE
        for(int j=0;j<boards.length;j++){
            if(boards[row][j]=='Q'){
                return false;
            }
        }

        //VERTICAL LINE
        for(int i=0;i<boards[0].length;i++){
            if(boards[i][col]=='Q'){
                return false;
            }
        }

        //upper left
        int r=row;
        for(int c=col;c>=0 && r>=0;c--,r--){
            if(boards[r][c]=='Q'){
                return false;
            }
        }

        //upper right
        r=row;
        for(int c=col;c<boards.length && r>=0;c++,r--){
            if(boards[r][c]=='Q'){
                return false;
            }
        }

        //lower left
        r=row;
        for(int c=col;c>=0 && r<boards.length;c--,r++){
            if(boards[r][c]=='Q'){
                return false;
            }
        }

        //lower right
        r=row;
        for(int c=col;c<boards.length && r<boards.length;c++,r++){
             if(boards[r][c]=='Q'){
                return false;
            }
        }

        return true;
    }

       public static void saveBoard(char[][] boards,List<List<String>> allBoards){
        String row="";

        List<String> newBoard=new ArrayList<>();
        for(int i=0;i<boards.length;i++){
             row="";
                for(int j=0;j<boards[0].length;j++){
                    if(boards[i][j]=='Q'){
                        row +='Q';
                    }else{
                        row +='.';
                    }
                 
                }
                   newBoard.add(row);
       
                
        }
         allBoards.add(newBoard);
       }

    
}
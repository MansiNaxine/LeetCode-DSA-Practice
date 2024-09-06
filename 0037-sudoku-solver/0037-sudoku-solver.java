class Solution {
    public void solveSudoku(char[][] board) {

        if(solve(board)){
            display(board);
        }
        System.out.println();
        
    }

    public static void display(char[][] board){
        for(char[] arr:board){
            for(char element:arr){
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }


    public static boolean solve(char[][] board){
        int row=-1;
        int col=-1;

        boolean isEmpty=true;

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]=='.'){
                    row=i;
                    col=j;
                    isEmpty=false;
                    break;
                }
            }

            if(!isEmpty){
                break;
            }
        }

        if(isEmpty){
            return true;
        }

        for(int num=1; num<=9;num++){
            if(isSafe(board,row,col,num)){
                board[row][col]=(char)(num+'0');

                if(solve(board)){
                    return true;
                }else{
                    board[row][col]='.';
                }
            }
        }

        return false;

    }


    public static boolean isSafe(char[][] board,int row,int col, int num){

        //to check in rows
        for(int i=0;i<board.length;i++){
            if(board[row][i]==(char)(num+'0')){
                return false;
            }
        }

        //to check in columns
        for(int i=0;i<board.length;i++){
            if(board[i][col]==(char)(num+'0')){
                return false;
            }
        }

        //to check in 3*3 matrix
        int sqrt=(int)(Math.sqrt(board.length));
        int rowStart=row-row%3;
        int colStart=col-col%3;

        for(int i=rowStart;i<rowStart+sqrt;i++){
            for(int j=colStart;j<colStart+sqrt;j++){
                if(board[i][j]==(char)(num+'0')){
                    return false;
                }
            }
        }

        return true;
    }
}
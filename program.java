package sudokoSolver;
import java.util.*;


public class program {
	
	public static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
	public static boolean isSafe(char[][] board,int row, int col,int number) {
		// row and col
		
		for(int i=0;i<board.length;i++) {
			if((board[i][col]) == (char)(number + '0')) {
				return false;
			}
			if( (board[row][i]) == (char)(number + '0')) {
				return false;
			}
			
		}
		
		//grid
		
		int sr = (row/3) * 3;
		int sc = (col/3) * 3;
		
		for(int i=sr;i<sr+3;i++) {
			for(int j=sc;j<sc+3;j++) {
				if(board[i][j] == (char)(number + '0')) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean solver(char[][] board,int row,int col) {
		//BASE CASE
		
		if(row == board.length) {
			printBoard(board);
			return true;
		}
		
		int nrow=0;
		int ncol=0;
		
		if(col!=board.length-1) {
			nrow = row;
			ncol = col+1;
			
		}
		else {
			nrow = row +1;
			ncol=0;
		}
		if(board[row][col] !='.') {
//			printBoard(board);
			if(solver(board,nrow,ncol)) {
				return true;
			}
		}
		else {
			for(int i =1;i<=9;i++) {
				if(isSafe(board,row,col,i)) {
					board[row][col] = (char)(i+'0');
					if(solver(board,nrow,ncol)){
						return true;
					}
					else {
						board[row][col] = '.';
					}
				
				}
			}
		}
		return false;
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] board = new char[9][9];
		for(int i=0;i<board.length;i++) {
			String data = "";
			if(sc.hasNext()) {
				data = sc.nextLine();}
			else {
				break;
			}
			for(int j=0;j<board.length;j++) 
				board[i][j]=data.charAt(j);
			
			
		}
		

//		System.out.println(board[6][5]);
		boolean res = solver(board,0,0);
//		System.out.print(res);
//		printBoard(board);

		if(res == true) {
			System.out.print("solved");
//			printBoard(board);
		}
		else {
			System.out.print("cannot solve");
		}
		sc.close();
	}

}

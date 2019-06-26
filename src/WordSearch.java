
public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//time limit exceeds
	public boolean exist(char[][] board, String word) {
        char[] carr = word.toCharArray();
        char firstchar = carr[0];
        
        int col = board[0].length;
        int row = board.length;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j] == firstchar){
                    boolean found = existHelper(i, j, board, carr, 0);
                    if(found) return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean existHelper(int row, int col, char[][] board,  char[] carr, int char_i){
        System.out.println("char: " + carr[char_i]);
        if(char_i+1 > carr.length-1) return true;
        char save = board[row][col];
        board[row][col] = 0;
        boolean left, right, up, down;
        left = right = up = down = false;
        
        if(col-1 >= 0 && carr[char_i+1] == board[row][col-1])
            left = existHelper(row, col-1, board, carr, char_i+1);
        if(col+1 < board[0].length && carr[char_i+1] == board[row][col+1])
            right = existHelper(row, col+1, board, carr, char_i+1);
        if(row-1 >= 0 && carr[char_i+1] == board[row-1][col])
            up = existHelper(row-1, col, board, carr, char_i+1);
        if(row+1 < board.length && carr[char_i+1] == board[row+1][col])
            down = existHelper(row+1, col, board, carr, char_i+1);
        board[row][col] = save;
        
        if(left || right || up || down) return true;
        return false;
    }
    
    //---------- accepted
    public boolean existfast(char[][] board, String word) {
        char[] carr = word.toCharArray();
        char firstchar = carr[0];
        
        int col = board[0].length;
        int row = board.length;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j] == firstchar){
                    boolean found = existHelper(i, j, board, carr, 0);
                    if(found) return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean existHelperfast(int row, int col, char[][] board,  char[] carr, int char_i){
        if(char_i == carr.length) return true;
        if(row < 0 || row > board.length-1 || col < 0 || col > board[0].length-1 || board[row][col] == 0 || board[row][col] != carr[char_i])
            return false;
        
        char save = board[row][col];
        board[row][col] = 0;
        boolean left, right, up, down;
        left = right = up = down = false;
        
        left = existHelper(row, col-1, board, carr, char_i+1);
        right = existHelper(row, col+1, board, carr, char_i+1);
        up = existHelper(row-1, col, board, carr, char_i+1);
        down = existHelper(row+1, col, board, carr, char_i+1);
        if(left || right || up || down) return true;
        
        board[row][col] = save;
        return false;
    }

}

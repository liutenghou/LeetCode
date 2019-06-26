import java.util.HashSet;

public class MagicSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

public int numMagicSquaresInside(int[][] grid) {
        
        int squareCount = 0;
        
        for(int i=0; i<grid.length-2; i++){
            for(int j=0; j<grid[i].length-2; j++){
                squareCount += magicHelper(i, j, grid);
            }
        }
        
        return squareCount;
    }
    
    
    //3 by 3 only
    public int magicHelper(int x, int y, int[][] grid){
        int squaresize = 3;
        
        //check unique
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(2);
        hs.add(3);
        hs.add(4);
        hs.add(5);
        hs.add(6);
        hs.add(7);
        hs.add(8);
        hs.add(9);
        
        for(int i=x; i<x+squaresize; i++){
            for(int j=y; j<y+squaresize; j++){
                int curr = grid[i][j];
                
                if(!hs.contains(curr)){
                    return 0;
                }else{
                    hs.remove(curr);
                }
            }
        }
        
        int rowsum = Integer.MIN_VALUE;
        int temp = 0;

        //going row by row adding
        for(int i=x; i<x+squaresize; i++){
            //go right by 3
            
            for(int j=y; j<y+squaresize; j++){
                temp += grid[i][j];
            }
            
            System.out.println("row temp:" + temp);
            if(rowsum == Integer.MIN_VALUE){
                rowsum = temp;
                temp = 0;
            }else{
                if(rowsum != temp) return 0;
                temp = 0;
            }
        }
        
        //going column by column
        temp = 0;
        for(int i=y; i<y+squaresize; i++){
            temp = 0;
            for(int j=x; j<x+squaresize; j++){
                temp += grid[j][i];
            }
            System.out.println("column temp:" + temp);
            if(rowsum == Integer.MIN_VALUE){
                rowsum = temp;
                temp = 0;
            }else{
                if(rowsum != temp) return 0;
                temp = 0;
            }
        }
        
        //diagonal 1
        temp = 0;
        int j = y;
        for(int i=x; i<x+squaresize; i++){
            temp += grid[i][j];
            j++;
        }
        
        System.out.println("diag1 temp:" + temp);
        if(rowsum == Integer.MIN_VALUE){
            rowsum = temp;
            temp = 0;
        }else{
            if(rowsum != temp) return 0;
            temp = 0;
        }
        
        //diagonal 2
        temp = 0;
        j = y+squaresize-1;
        for(int i=x; i<x+squaresize; i++){
            temp += grid[i][j];
            j--;
        }
        System.out.println("diag2 temp:" + temp);
        if(rowsum == Integer.MIN_VALUE){
            rowsum = temp;
            temp = 0;
        }else{
            if(rowsum != temp) return 0;
            temp = 0;
        }
        
        return 1;
    }

}

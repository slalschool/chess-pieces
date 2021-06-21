public class King extends Piece implements ChessPiece{


    public King(int row, int column, boolean color) {
        super(row, column, color);
    }

    public boolean canMove(int row, int col) {
        if(row > 9 || col > 9){
            return false;
        }
        int currentRow = this.getRow();
        int currentCol = this.getColumn();
        return Math.abs(row-currentRow) <= 1 || Math.abs(col-currentCol) <= 1;
    }

    public boolean canTake(ChessPiece piece) { ;
        boolean color = piece.getColor();
        int row = piece.getRow();
        int col = piece.getColumn();
        int rowDiff = Math.abs(row - this.row);
        int colDiff = Math.abs(col - this.column);

        if (rowDiff <= 1 && colDiff <= 1) {
            if (color == true) {
                if (board.blackAtPosition(row, col) == true) {
                    return true;
                }
            }
            else {
                if (board.whiteAtPosition(row, col) == true) {
                    return true;
                }
            }
        }
        return false;
    }

}

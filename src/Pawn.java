public class Pawn extends Piece implements ChessPiece{


    public Pawn(int row, int column, boolean color) {
        super(row, column, color);
    }

    public boolean canMove(int row, int col) {

        if (row == this.row + 1 && col == this.getColumn() && board.blackAtPosition(row, col) == false && board.whiteAtPosition(row, col) == false) {
            return true;
        }
        return false;
    }

    public boolean canTake(ChessPiece piece) {
        int row = piece.getRow();
        int col = piece.getColumn();
        boolean color = piece.getColor();

        if ((row == this.row + 1 && col == this.getColumn() + 1) || (row == this.row + 1 && col == this.getColumn() - 1)) {
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
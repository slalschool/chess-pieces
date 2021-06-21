public class Knight extends Piece implements ChessPiece{


    public Knight(int row, int column, boolean color) {
        super(row, column, color);
    }

    public boolean canMove(int row, int col) {
        if (row == this.row + 1 || row == this.row - 1) {
            if (col == this.column + 2 || col == this.column - 2) {
                if (board.blackAtPosition(row, col) == false && board.whiteAtPosition(row, col) == false) {
                    return true;
                }
                return false;
            }
            return false;
        } else if (row == this.row + 2 || row == this.row - 2) {
            if (col == this.column + 1 || col == this.column - 2) {
                if (board.blackAtPosition(row, col) == false && board.whiteAtPosition(row, col) == false) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public boolean canTake(ChessPiece piece) {
        int row = piece.getRow();
        int col = piece.getColumn();
        boolean color = piece.getColor();

        if (row == this.row + 1 || row == this.row - 1) {
            if (col == this.column + 2 || col == this.column - 2) {
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
        else if (row == this.row + 2 || row == this.row - 2) {
            if (col == this.column + 1 || col == this.column - 1) {
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
        return false;
    }

}

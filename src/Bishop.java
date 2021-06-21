public class Bishop extends Piece implements ChessPiece {

    public Bishop(int row, int column, boolean color) {

        super(row, column, color);
    }

    public boolean canMove(int row, int col) {

        int check = this.row;
        int check2 = this.column;
        int rowDiff = Math.abs(row - this.row);
        int colDiff = Math.abs(col - this.column);

        if (rowDiff != colDiff) {
            return false;
        }

        if (col > this.column) {
            check2 = col;
            col = this.column;
        }

        if (row > this.row) {
            check = row;
            row = this.row;
        }

        int j = col;
        for (int i = row; i <= check; i++) {
                    if (board.blackAtPosition(i, j) == true || board.whiteAtPosition(i, j) == true) {
                        return false;
                }
                    j++;
        }

        return true;
    }

    public boolean canTake(ChessPiece piece) {

        int check = this.row;
        int check2 = this.column;
        int row = piece.getRow();
        int col = piece.getColumn();
        boolean color = piece.getColor();
        int rowDiff = Math.abs(row - this.row);
        int colDiff = Math.abs(col - this.column);


        if (rowDiff != colDiff) {
            return false;
        }

        if (col > this.column) {
            check2 = col;
            col = this.column;
        }

        if (row > this.row) {
            check = row;
            row = this.row;
        }

        int j = col;
        for (int i = row; i < check; i++) {
            if (board.blackAtPosition(i, j) == true || board.whiteAtPosition(i, j) == true) {
                return false;
            }
            j++;
        }

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
        return false;
    }
}

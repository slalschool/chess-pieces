public class Queen extends Piece implements ChessPiece{


    public Queen(int row, int column, boolean color) {
        super(row, column, color);
    }

    public boolean canMove(int row, int col) {
        int rowDiff = Math.abs(row - this.row);
        int colDiff = Math.abs(col - this.column);
        if (row == this.row || col == this.column) {
            int check = this.row;
            int check2 = this.column;


            if (board.blackAtPosition(row, col) == false && board.whiteAtPosition(row, col) == false) {
                if (row == this.row) {
                    if (col > this.column) {
                        check2 = col;
                        col = this.column;
                    }
                    for (int i = col; i <= check2; i++) {
                        if (board.blackAtPosition(row, i) == true || board.whiteAtPosition(row, i) == true) {
                            return false;
                        }
                    }
                } else if (col == this.column) {
                    if (row > this.row) {
                        check = row;
                        row = this.row;
                    }
                    for (int i = row; i <= check; i++) {
                        if (board.blackAtPosition(i, col) == true || board.whiteAtPosition(i, col) == true) {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
                return true;
            }

            return false;
        } else if (rowDiff == colDiff) {
            int check = this.row;
            int check2 = this.column;
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
        return false;
    }

    public boolean canTake(ChessPiece piece) {
        int row = piece.getRow();
        int col = piece.getColumn();
        boolean color = piece.getColor();
        int rowDiff = Math.abs(row - this.row);
        int colDiff = Math.abs(col - this.column);

        if (row == this.row || col == this.column) {
            int check = this.row;
            int check2 = this.column;


            if (row == this.row) {
                if (col > this.column) {
                    check2 = col;
                    col = this.column;
                }
                for (int i = col; i < check2; i++) {
                    if (board.blackAtPosition(row, i) == true || board.whiteAtPosition(row, i) == true) {
                        return false;
                    }
                }
            }
            else if (col == this.column) {
                if (row > this.row) {
                    check = row;
                    row = this.row;
                }
                for (int i = row; i < check; i++) {
                    if (board.blackAtPosition(i, col) == true || board.whiteAtPosition(i, col) == true) {
                        return false;
                    }
                }
            }
            else {
                return false;
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
        else if (rowDiff == colDiff) {
            int check = this.row;
            int check2 = this.column;
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
        return false;
    }

}

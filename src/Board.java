import java.util.ArrayList;

public class Board {

    private ArrayList<ChessPiece> blackPieces;
    private ArrayList<ChessPiece> whitePieces;

    private static Board board;

    private Board() {
        blackPieces = new ArrayList<ChessPiece>();
        whitePieces = new ArrayList<ChessPiece>();
        arrange();
    }

     public static Board getBoard() {
        if (board == null) {
            board = new Board();
        }
        return board;
     }

    private void arrange() {
        blackPieces.add(new Rook(7, 0, false));
        blackPieces.add(new Knight(7, 1, false));
        blackPieces.add(new Bishop(7, 2, false));
        blackPieces.add(new King(7, 3, false));
        blackPieces.add(new Queen(7, 4, false));
        blackPieces.add(new Bishop(7, 5, false));
        blackPieces.add(new Knight(7, 6, false));
        blackPieces.add(new Rook(7, 7, false));

        for (int i = 0; i <= 7; i++) {
            blackPieces.add(new Pawn(6, i, false));
        }

        whitePieces.add(new Rook(1, 7, true));
        whitePieces.add(new Knight(1, 6, true));
        whitePieces.add(new Bishop(1, 5, true));
        whitePieces.add(new King(1, 4, true));
        whitePieces.add(new Queen(1, 3, true));
        whitePieces.add(new Bishop(1, 2, true));
        whitePieces.add(new Knight(1, 1, true));
        whitePieces.add(new Rook(1, 0, true));

        for (int i = 0; i <= 7; i++) {
            whitePieces.add(new Pawn(0, i, true));
        }
    }

    public boolean blackAtPosition(int row, int col) {

        for (int i = 0; i < blackPieces.size(); i++) {
            if (blackPieces.get(i).getRow() == row && blackPieces.get(i).getColumn() == col) {
                return true;
            }
        }
        return false;
    }

    public boolean whiteAtPosition(int row, int col) {

        for (int i = 0; i < whitePieces.size(); i++) {
            if (whitePieces.get(i).getRow() == row && whitePieces.get(i).getColumn() == col) {
                return true;
            }
        }
        return false;
    }
}

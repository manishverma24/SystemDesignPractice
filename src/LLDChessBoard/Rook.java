package LLDChessBoard;

public class Rook extends Piece {
    public Rook(boolean white) {
        super(white);
    }
    @Override
    public boolean moveValid(Board board, Spot start, Spot end) {
        return false;
    }
}

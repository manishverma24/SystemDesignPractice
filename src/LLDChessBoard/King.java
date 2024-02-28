package LLDChessBoard;

public class King extends Piece {
    public King(boolean white) {
        super(white);
    }

    @Override
    public boolean moveValid(Board board, Spot start, Spot end) {
        return false;
    }
}

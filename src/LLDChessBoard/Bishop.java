package LLDChessBoard;

public class Bishop extends Piece {
    public Bishop(boolean white) {
        super(white);
    }

    @Override
    public boolean moveValid(Board board, Spot start, Spot end) {
        return false;
    }

}

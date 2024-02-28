package LLDChessBoard;

import java.util.List;

public class Game {
    private Player[] players;
    private Board board;
    private Player currentPlayer;
    private GameStatus status;
    private List<Move> movesPlayed;

    private void startGame(Player p1, Player p2) {
        players[0] = p1;
        players[1] = p2;

        board.startBoard();

        if(p1.isWhiteSide()) {
            this.currentPlayer = p1;
        } else {
            this.currentPlayer = p2;
        }

        movesPlayed.clear();
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public boolean playerMove(Player player, int startX, int startY, int endX, int endY) throws Exception {
        Spot start = board.getSpot(startX, startY);
        Spot end = board.getSpot(endX, endY);

        Piece sourcePiece = start.getPiece();
        if (!sourcePiece.moveValid(board, start, end))
            return false;

        Piece destPiece = end.getPiece();
        if (destPiece != null){
            destPiece.setKilled(true);
        }
        end.setPiece(sourcePiece);

        if ( destPiece instanceof King &&
                sourcePiece.isWhite() != destPiece.isWhite()) {
            if(player.isWhiteSide()) {
                this.setStatus(GameStatus.WHITE_WIN);
            } else {
                this.setStatus(GameStatus.BLACK_WIN);
            }
        }

        if(this.currentPlayer == players[0]) {
            this.currentPlayer = players[1];
        } else {
            this.currentPlayer = players[0];
        }
        return true;
    }
}


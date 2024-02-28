package LLDChessBoard;

public class Board {
    Spot[][] spots;

    public Spot getSpot(int x, int y) throws Exception {

        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new Exception("Index out of bound");
        }

        return spots[x][y];
    }

    public Board() {
        this.startBoard();
    }

    public void startBoard() {
        // initialize white pieces
        spots[0][0] = new Spot(0, 0, new Rook(true));
        spots[0][1] = new Spot(0, 1, new Knight(true));
        spots[0][2] = new Spot(0, 3, new Bishop(true));
        spots[0][3] = new Spot(0, 4, new King(true));
        spots[0][4] = new Spot(0, 5, new Queen(true));
        spots[0][5] = new Spot(0, 6, new Bishop(true));
        spots[0][6] = new Spot(0, 7, new Knight(true));
        spots[0][7] = new Spot(0, 8, new Rook(true));
        //...
        spots[1][0] = new Spot(1, 0, new Pawn(true));
        spots[1][1] = new Spot(1, 1, new Pawn(true));
        spots[1][2] = new Spot(1, 2, new Pawn(true));
        spots[1][3] = new Spot(1, 3, new Pawn(true));
        spots[1][4] = new Spot(1, 4, new Pawn(true));
        spots[1][5] = new Spot(1, 5, new Pawn(true));
        spots[1][6] = new Spot(1, 6, new Pawn(true));
        spots[1][7] = new Spot(1, 7, new Pawn(true));
        //...

        // initialize black pieces
        spots[7][0] = new Spot(7, 0, new Rook(false));
        spots[7][1] = new Spot(7, 1, new Knight(false));
        spots[7][2] = new Spot(7, 2, new Bishop(false));
        spots[7][3] = new Spot(7, 3, new Queen(false));
        spots[7][4] = new Spot(7, 4, new King(false));
        spots[7][5] = new Spot(7, 5, new Bishop(false));
        spots[7][6] = new Spot(7, 6, new Knight(false));
        spots[7][7] = new Spot(7, 7, new Rook(false));
        //...
        spots[6][0] = new Spot(6, 0, new Pawn(false));
        spots[6][1] = new Spot(6, 1, new Pawn(false));
        spots[6][2] = new Spot(6, 2, new Pawn(false));
        spots[6][3] = new Spot(6, 3, new Pawn(false));
        spots[6][4] = new Spot(6, 4, new Pawn(false));
        spots[6][5] = new Spot(6, 5, new Pawn(false));
        spots[6][6] = new Spot(6, 6, new Pawn(false));
        spots[6][7] = new Spot(6, 7, new Pawn(false));
        //...

        // initialize remaining boxes without any piece
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                spots[i][j] = new Spot(i, j, null);
            }
        }
    }
}

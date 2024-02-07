import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    public TicTacToeViewer board;
    private Image x, o;
    private int row;
    private int col;
    private boolean isWinningSquare;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col, TicTacToeViewer board) {
        this.row = row;
        this.col = col;
        this.board = board;
        x = board.getPiecesImages()[1];
        o = board.getPiecesImages()[0];
        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }
    public void draw(Graphics g) {

        if (isWinningSquare) {
            g.setColor(Color.green);
            g.fillRect( (col + 1) * 200 - 25, (row + 1) * 200 - 75,200, 200);
            g.setColor((Color.black));
            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 3; j ++) {
                    g.drawRect(j * 200 - 25, i * 200 - 75, 200, 200);
                }
            }
        }
        if (marker.equals(TicTacToe.X_MARKER)) {
            g.drawImage(x, (col + 1) * 200 - 25, (row + 1) * 200 - 75, 200, 200, board);
        }
        else if (marker.equals(TicTacToe.O_MARKER)){
            g.drawImage(o, (col + 1) * 200 - 25, (row + 1) * 200 - 75,200, 200, board);
        }
    }

}

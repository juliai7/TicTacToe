import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    private Image[] piecesImages;
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    private TicTacToe t;
    public TicTacToeViewer(TicTacToe t) {
        piecesImages = new Image[2];
        piecesImages[0] = new ImageIcon("Resources/O.png").getImage();
        piecesImages[1] = new ImageIcon("Resources/X.png").getImage();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        this.t = t;
    }

    public Image[] getPiecesImages() {
        return piecesImages;
    }

    public void paint (Graphics g) {
        g.setColor(Color.black);

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j ++) {
                g.drawRect(j * 200 - 25, i * 200 - 75, 200, 200);
            }
        }


        g.setFont(new Font("Serif", Font.PLAIN, 30));
        g.setColor(Color.red);
        for (int i = 0; i < 3; i++) {
            String s = Integer.toString(i);
            g.drawString(s, (i + 1) * 200 + 65, 100);
        }
        for (int i = 0; i < 3; i++) {
            String s = Integer.toString(i);
            g.drawString(s, 130, (i + 1) * 200 + 25);
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                t.getBoard()[i][j].draw(g);
            }
        }

    }


}

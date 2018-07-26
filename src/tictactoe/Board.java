/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javax.swing.*;

import java.awt.*;

import static java.awt.Color.*;
import static tictactoe.Cell.Figure.*;

/**
 * @author Kapellan
 */
public class Board extends JComponent {

    Data data;
    JFrame frame;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem itemNewGame;
    JMenuItem itemAbout;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        paintBoardGrid(g2d);
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                int X = data.cells[r][c].X;
                int Y = data.cells[r][c].Y;
                switch (data.cells[r][c].figure) {
                    case TIC:
                        paintTic(g2d, X, Y);
                        break;
                    case TAC:
                        paintTac(g2d, X, Y);
                        break;
                    case TIC_WON:
                        paintCellBack(g2d, X, Y, YELLOW);
                        paintTic(g2d, X, Y);
                        break;
                    case TAC_WON:
                        paintCellBack(g2d, X, Y, YELLOW);
                        paintTac(g2d, X, Y);
                        break;
                }
            }
        }
        repaint();
    }

    void paintTic(Graphics2D g2d, int X, int Y) {
        g2d.setColor(RED);
        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.drawLine(X, Y, X + data.CELL_SIZE, Y + data.CELL_SIZE);
        g2d.drawLine(X + data.CELL_SIZE, Y, X, Y + data.CELL_SIZE);
    }

    void paintTac(Graphics2D g2d, int X, int Y) {
        g2d.setColor(BLUE);
        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.drawOval(X, Y, data.CELL_SIZE, data.CELL_SIZE);
    }

    void paintBoardGrid(Graphics2D g2d) {
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRect(data.PADDING, data.PADDING, data.CELL_SIZE * 3, data.CELL_SIZE * 3);
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                g2d.setColor(BLACK);
                g2d.drawRect(data.cells[r][c].X, data.cells[r][c].Y, data.CELL_SIZE, data.CELL_SIZE);
            }
        }
    }

    void paintCellBack(Graphics2D g2d, int X, int Y, Color color) {
        g2d.setColor(color);
        g2d.fillRect(X + 1, Y + 1, data.CELL_SIZE - 1, data.CELL_SIZE - 1);
    }

    public Board(Data data) {
        this.data = data;
        this.setMinimumSize(data.PREFFERED_SIZE);
    }

    void setGui() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            frame = new JFrame("TicTacToe (Крестики-нолики)");
            menuBar = new JMenuBar();
            menu = new JMenu("Game");
            itemNewGame = new JMenuItem("New game");
            itemAbout = new JMenuItem("About");

            menu.add(itemNewGame);
            menu.add(itemAbout);
            menuBar.add(menu);

            frame.getContentPane().add(menuBar, BorderLayout.NORTH);
            frame.getContentPane().add(this, BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setPreferredSize(data.PREFFERED_SIZE);
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Data data = new Data();
        Actions actions = new Actions(data);
        Board board = new Board(data);
        board.setGui();
        board.addMouseListener(actions);
        board.itemNewGame.addActionListener(actions);
        board.itemAbout.addActionListener(actions);
    }
}
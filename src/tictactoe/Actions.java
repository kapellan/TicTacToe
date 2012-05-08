package tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Kapellan
 */
public class Actions implements MouseListener, ActionListener {

    Data data;

    @Override
    public void mousePressed(MouseEvent e) {
        data.clickOccurred(e.getX(), e.getY());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("New game")) {
            data.setDefault();
        }
        if (e.getActionCommand().equals("About")) {
            JOptionPane.showMessageDialog(null, "       Developed by Kapellan \n steel.lights.gardens@gmail.com","   About",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public Actions(Data data) {
        this.data = data;
    }
}

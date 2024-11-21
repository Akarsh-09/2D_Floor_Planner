

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class JPLabel extends JLabel{
    Point initialClick;
    JPanel parent;
    JPLabel(JPanel parent) {
        this.parent=parent;
        this.setBounds(0, 0, 30, 30);
        Mouse();
        
    }
    void Mouse(){
        this.addMouseListener(new MouseListener() {
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                if(SwingUtilities.isRightMouseButton(e)){
                    final JPopupMenu popupmenu = new JPopupMenu("Edit");   
                    JMenuItem delete = new JMenuItem("delete");  
                    popupmenu.add(delete);
                    
                }
            }


            public void mouseClicked(MouseEvent e) {
            }


            public void mouseReleased(MouseEvent e) {
            }


            public void mouseEntered(MouseEvent e) {
            }


            public void mouseExited(MouseEvent e) {
            }
        });
        this.addMouseMotionListener(new MouseAdapter() {
            
            public void mouseDragged(MouseEvent e) {
                int thisX = ((JLabel) e.getSource()).getX();
                int thisY = ((JLabel) e.getSource()).getY();

                int xMoved = e.getX() - initialClick.x;
                int yMoved = e.getY() - initialClick.y;

                int newX = thisX + xMoved;
                int newY = thisY + yMoved;

                Point new01 = new Point(newX, newY);
                Point new10 = new Point(new01.x + ((JLabel) e.getSource()).getWidth(),
                        new01.y + ((JLabel) e.getSource()).getHeight());

                if (new01.x < 0 || new01.y < 0 || new10.x > parent.getWidth() || parent.getHeight() < new10.y)
                    ;

                else {
                    ((JLabel) e.getSource()).setLocation(newX, newY);
                }
            }
        });
    }
}

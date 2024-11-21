

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;


public class JPPanel extends JPanel {
    Point initialClick;
    ArrayList<JPPanel> rooms=new ArrayList<JPPanel>();
    JLayeredPane floor;
    JPPanel(ArrayList<JPPanel> rooms,JLayeredPane floor){
        this.rooms=rooms;
        this.floor=floor;
        Mouse();
    }
    void Mouse(){
        this.addMouseListener(new MouseListener() {
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                if(SwingUtilities.isRightMouseButton(e)){
                    JPPanel rightPanel=(JPPanel)e.getSource();
                    final JPopupMenu popupmenu = new JPopupMenu("Edit");   
                    JMenuItem delete = new JMenuItem("delete");  
                    JMenu Furniture = new JMenu("Furniture");
                    JMenuItem Bed=new JMenuItem("Bed");
                    Furniture.add(Bed);
                    JMenuItem Chair=new JMenuItem("Chair");
                    Furniture.add(Chair);
                    JMenuItem Sofa=new JMenuItem("Sofa");
                    Furniture.add(Sofa); 
                    JMenuItem Diningset=new JMenuItem("Dining Set");
                    Furniture.add(Diningset);
                    JMenu Fixture=new JMenu("Fixtures");
                    JMenuItem Stove=new JMenuItem("Stove");
                    Fixture.add(Stove);
                    JMenuItem Kitsink=new JMenuItem("Kitchen sink");
                    Fixture.add(Kitsink);
                    JMenuItem Shower=new JMenuItem("Shower");
                    Fixture.add(Shower); 
                    JMenuItem Wash=new JMenuItem("Washbasin");
                    Fixture.add(Wash);
                    JMenuItem Commode=new JMenuItem("Commode"); 
                    Fixture.add(Commode);
                    popupmenu.add(delete); 
                    if(rightPanel.getBackground().equals(new Color(0x0050FF))  || rightPanel.getBackground().equals(new Color(0xFF1515))){
                        popupmenu.add(Fixture);
                    }
                    else{popupmenu.add(Furniture); }
                    popupmenu.show((JPanel)e.getSource() , e.getX(), e.getY());  
                   delete.addActionListener(new ActionListener(){  
                    public void actionPerformed(ActionEvent e) { 
                        rooms.remove(rightPanel);
                        // roomNum--;
                        floor.remove(rightPanel);
                        floor.revalidate();
                        floor.repaint();
                    }  
                   });  
                   Bed.addActionListener(new ActionListener(){  
                       public void actionPerformed(ActionEvent f) {              
                           ImageIcon bed=new ImageIcon("D:\\Studies\\VS Code\\2D_Floor_Planner\\Hello.png");
                           JPLabel bedlabel=new JPLabel(rightPanel);
                           bedlabel.setIcon(bed);
                        rightPanel.setLayout(null);
                           rightPanel.add(bedlabel);
                           rightPanel.revalidate();
                           rightPanel.repaint();
                       }  
                      });  
                
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
            @Override
            public void mouseDragged(MouseEvent e) {
                int thisX = ((JPanel) e.getSource()).getX();
                int thisY = ((JPanel) e.getSource()).getY();

                int xMoved = e.getX() - initialClick.x;
                int yMoved = e.getY() - initialClick.y;

                int newX = thisX + xMoved;
                int newY = thisY + yMoved;
                int rounder = 25;
                if (newX%10<=rounder/2){
                    newX-=newX%rounder;
                }
                else{
                    newX+=rounder-newX%(rounder/2);
                }
                if (newY%10<=rounder/2){
                    newY-=newY%rounder;
                }
                else{
                    newY+=rounder-newY%(rounder/2);
                }
                
                ((JPanel) e.getSource()).setLocation(newX, newY);
            }
        });
    }
}

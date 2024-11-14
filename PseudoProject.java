import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PseudoProject implements ActionListener{

    public JFrame frame;
    public JPanel canvasPanel;    // The panel where the floor plan is to be drawn
    public JPanel controlPanel;   // The panel where the controls buttons will be added
    public ArrayList<JPanel> rooms = new ArrayList<JPanel>();
    public JButton newRoom;
    public JLayeredPane floor;
    int roomNum = 0;
    int frameWidth;
    int frameHeight;

    public PseudoProject() {

        frame = new JFrame("2D Floor Planner");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(null);

        frame.setVisible(true);

        frameHeight = frame.getHeight();
        frameWidth = frame.getWidth();
        
        System.out.println(frameHeight);
        System.out.println(frameWidth);

        // Maximum frame = ~1280x775

        controlPanel = new JPanel();
        canvasPanel = new JPanel();

        //Canvas Panel

        canvasPanel.setBounds((int)((frameWidth - 30) / 4) + 20, 10, (int)(((frameWidth - 30) * 3) / 4), (int)(frameHeight - 20));
        canvasPanel.setBackground(Color.lightGray);
        canvasPanel.setLayout(null);

        //Control Panel

        Border border = BorderFactory.createLineBorder(Color.black, 4);

        controlPanel.setBounds(10, 10, (int)((frameWidth - 30) / 4), (int)(frameHeight - 20)); //  ((frameWidth - 30) / 4)
        // controlPanel.setBounds(10, 10, 313, 725); //  ((frameWidth - 30) / 4)
        controlPanel.setBackground(new Color(0xffdc44));

        JPanel filePanel = new JPanel();
        filePanel.setBounds(30, 10, 253, 92);
        filePanel.setBackground(new Color(0xFFFFFF));

        JLabel newFile = new JLabel();
        ImageIcon ifile = new ImageIcon("ifile.jpg");
        newFile.setIcon(ifile);
        newFile.setBounds(0, 0, 70, 50);
        newFile.setBorder(border);

        filePanel.add(newFile);

        JPanel toolPanel = new JPanel();
        toolPanel.setBounds(30, 112, 253, 92);
        toolPanel.setBackground(new Color(0xFFFFFF));

        JPanel roomPanel = new JPanel();
        roomPanel.setBounds(30, 214, 253, 92);
        roomPanel.setBackground(new Color(0xFFFFFF));

        JPanel doorPanel = new JPanel();
        doorPanel.setBounds(30, 316, 253, 92);
        doorPanel.setBackground(new Color(0xFFFFFF));

        JPanel windowPanel = new JPanel();
        windowPanel.setBounds(30, 418, 253, 92);
        windowPanel.setBackground(new Color(0xFFFFFF));

        JPanel furniturePanel = new JPanel();
        furniturePanel.setBounds(30, 520, 253, 92);
        furniturePanel.setBackground(new Color(0xFFFFFF));

        JPanel fixturePanel = new JPanel();
        fixturePanel.setBounds(30, 622, 253, 92);
        fixturePanel.setBackground(new Color(0xFFFFFF));

        floor = new JLayeredPane();
        floor.setBorder(border);
        floor.setBounds(70,70,400,400);
        floor.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        canvasPanel.add(floor);


// Vikrant





































        newRoom = new JButton("New Room");
        newRoom.setBounds(20, 20, 150, 50);
        roomPanel.add(newRoom);

        newRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == newRoom) {

                    JDialog dialog = new JDialog(frame, "Room Type");

                    JTextField text1 = new JTextField();
                    JTextField text2 = new JTextField();
                    // StringBuilder roomtype = new StringBuilder("Bedroom");

                    String roomName[] = { "Bedroom", "Bathroom", "Kitchen", "Dining Room", "Drawing Room"};

                    JComboBox roomType = new JComboBox(roomName);

                    // roomType.addItemListener(new ItemListener() {

                    //     @Override
                    //     public void itemStateChanged(ItemEvent e) {

                            
                    //         // roomtype = new StringBuilder(roomType.getSelectedItem().toString());
                    //     }
                    // });

                    roomType.setBounds(50, 25, 200, 35);

                    dialog.add(roomType);
                    





                    text1.setBounds(100, 80, 100, 30);
                    text2.setBounds(100, 120, 100, 30);

                    JLabel l1 = new JLabel("Length");
                    JLabel l2 = new JLabel("Width");

                    l1.setBounds(30, 80, 100, 30);
                    l2.setBounds(30, 120, 100, 30);

                    JButton sub = new JButton("Submit");
                    sub.setBounds(120, 170, 60, 40);

                    
                    sub.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int room_Length = Integer.parseInt(text1.getText());
                            int room_Width = Integer.parseInt(text2.getText());
                            Addroom(room_Length, room_Width, roomType.getSelectedItem().toString());
                            dialog.dispose();
                        }
                    });

                    dialog.add(text1);
                    dialog.add(text2);
                    dialog.add(l1);
                    dialog.add(l2);
                    dialog.add(sub);

                    dialog.setSize(300, 300);
                    dialog.setLocation(200, 200);
                    dialog.setLayout(null);
                    dialog.setVisible(true);

                }
            }
        });








































        controlPanel.add(filePanel);
        controlPanel.add(toolPanel);
        controlPanel.add(roomPanel);
        controlPanel.add(doorPanel);
        controlPanel.add(windowPanel);
        controlPanel.add(furniturePanel);
        controlPanel.add(fixturePanel);
        controlPanel.setLayout(null);

        frame.add(controlPanel);
        frame.add(canvasPanel);

        frame.setLayout(null);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JPanel j1=new JPanel();
        j1.setPreferredSize(new Dimension(100, 100));
        PseudoProject p1 = new PseudoProject();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == newRoom)
        {
            System.out.println("Hello");
        }
    }

    public void Addroom(int l, int b, String roomType)
    {
        rooms.add(new JPanel());
        rooms.get(roomNum).setPreferredSize(new Dimension(b, l));
        // rooms.get(roomNum).setBounds(100,100,l,b);
        rooms.get(roomNum).setVisible(true);
        
        rooms.get(roomNum).setBorder(BorderFactory.createLineBorder(Color.black, 2));
        floor.add(rooms.get(roomNum),Integer.valueOf(2));
        roomNum++;

        System.out.println(roomType + " - " + l + " " + b);

        floor.revalidate();
        floor.repaint();
    }
}
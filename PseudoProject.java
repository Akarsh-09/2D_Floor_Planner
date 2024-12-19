import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

// public class PseudoProject implements ActionListener{
public class PseudoProject implements MouseListener {

    public JFrame frame;
    public JPanel canvasPanel;
    public JPanel controlPanel;
    public ArrayList<JPanel> rooms = new ArrayList<JPanel>();
    public JButton newRoom;
    public JButton NewPlan;
    public JButton Open;
    public JButton Save;
    public JLayeredPane floor;
    int roomNum = 0;
    int frameWidth;
    int frameHeight;
    int xCoord = 0;
    int yCoord = 0;
    int yCoordMax = 0;

    public PseudoProject() {

        frame = new JFrame("2D Floor Planner");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(null);

        frame.setVisible(true);

        frameHeight = frame.getHeight();
        frameWidth = frame.getWidth();

        Border border = BorderFactory.createLineBorder(Color.black, 3);
        
        // System.out.println(frameHeight);
        // System.out.println(frameWidth);

        // Maximum frame = ~1280x775

        controlPanel = new JPanel();
        canvasPanel = new JPanel();

        //Canvas Panel

        canvasPanel.setBounds((int)((frameWidth - 30) / 4) + 20, 10, (int)(((frameWidth - 30) * 3) / 4), (int)(frameHeight - 50));
        // canvasPanel.setBounds(333, 10, 935, 725);
        canvasPanel.setBackground(Color.lightGray);
        canvasPanel.setBorder(border);
        canvasPanel.addMouseListener(this);
        canvasPanel.setLayout(null);

        //Control Panel

        controlPanel.setBounds(10, 10, (int)((frameWidth - 30) / 4), (int)(frameHeight - 50));
        // controlPanel.setBounds(10, 10, 313, 725);
        controlPanel.setBackground(new Color(0xffdc44));
        controlPanel.setBorder(border);

        JPanel filePanel = new JPanel();
        filePanel.setBounds(30, 10, 253, 92);
        filePanel.setBackground(new Color(0xFFFFFF));
        filePanel.setBorder(border);

        // JLabel newFile = new JLabel();
        // ImageIcon ifile = new ImageIcon("ifile.jpg");
        // newFile.setIcon(ifile);
        // filePanel.add(newFile);
        

        JPanel toolPanel = new JPanel();
        toolPanel.setBounds(30, 112, 253, 92);
        toolPanel.setBackground(new Color(0xFFFFFF));
        toolPanel.setBorder(border);

        JPanel roomPanel = new JPanel();
        roomPanel.setBounds(30, 214, 253, 92);
        roomPanel.setBackground(new Color(0xFFFFFF));
        roomPanel.setBorder(border);

        JPanel doorPanel = new JPanel();
        doorPanel.setBounds(30, 316, 253, 92);
        doorPanel.setBackground(new Color(0xFFFFFF));
        doorPanel.setBorder(border);

        JPanel windowPanel = new JPanel();
        windowPanel.setBounds(30, 418, 253, 92);
        windowPanel.setBackground(new Color(0xFFFFFF));
        windowPanel.setBorder(border);

        JPanel furniturePanel = new JPanel();
        furniturePanel.setBounds(30, 520, 253, 92);
        furniturePanel.setBackground(new Color(0xFFFFFF));
        furniturePanel.setBorder(border);

        JPanel fixturePanel = new JPanel();
        fixturePanel.setBounds(30, 622, 253, 92);
        fixturePanel.setBackground(new Color(0xFFFFFF));
        fixturePanel.setBorder(border); 

        floor = new JLayeredPane();
        floor.setBorder(border);
        floor.setBounds(70,70,795,585);
        // floor.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        floor.setLayout(null);
        
        canvasPanel.add(floor);


        // NewPlan.addActionListener(e -> NewPlanFile());
        // Open.addActionListener(e -> OpenFile());
        // Save.addActionListener(e -> SaveFile());


// Vikrant

































        NewPlan = new JButton("New Plan");
        NewPlan.setFocusable(false);
        NewPlan.setFont(new Font("Serif", Font.PLAIN, 18));
        NewPlan.setBounds(80, 20, 150, 50);
        // NewPlan.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        Open = new JButton("Open");
        Open.setFocusable(false);
        Open.setFont(new Font("Serif", Font.PLAIN, 20));
        Open.setBounds(80, 90, 150, 50);

        Save = new JButton("Save");
        Save.setFocusable(false);
        Save.setFont(new Font("Serif", Font.PLAIN, 20));
        Save.setBounds(80, 160, 150, 50);

        controlPanel.add(NewPlan);
        controlPanel.add(Open);
        controlPanel.add(Save);

        // filePanel.setLayout(null);

        newRoom = new JButton("New Room                     +");
        newRoom.setFont(new Font("Serif", Font.PLAIN, 20));
        newRoom.setFocusable(false);
        newRoom.setBounds(30, 230, 250, 50);
        // newRoom.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        controlPanel.add(newRoom);

















        newRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == newRoom) {
                    
                    JDialog dialog = new JDialog(frame, "Room Type");
    
                    JTextField text1 = new JTextField();
                    JTextField text2 = new JTextField();
                        // StringBuilder roomtype = new StringBuilder("Bedroom");
    
                    String roomName[] = {"Bedroom", "Bathroom", "Kitchen", "Dining Room", "Drawing Room"};
    
                    JComboBox roomType = new JComboBox(roomName);
    
                        // roomType.addItemListener(new ItemListener() {
    
                        //     @Override
                        //     public void itemStateChanged(ItemEvent e) {
    
                                
                        //         // roomtype = new StringBuilder(roomType.getSelectedItem().toString());
                        //     }
                        // });
    
                    roomType.setBounds(50, 25, 200, 35);
                    
                    dialog.add(roomType);
                    text1.setBounds(110, 80, 100, 30);
                    text2.setBounds(110, 120, 100, 30);
    
                    JLabel l1 = new JLabel("Length");
                    JLabel l2 = new JLabel("Width");

                    l1.setBounds(50, 80, 100, 30);
                    l2.setBounds(50, 120, 100, 30);

                    JButton submit = new JButton("Submit");
                    submit.setBounds(120, 180, 80, 40);
    
                        
                    submit.addActionListener(new ActionListener() {
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
                    dialog.add(submit);

                    dialog.setSize(300, 300);
                    dialog.setLocation(200, 200);
                    dialog.setLayout(null);
                    dialog.setVisible(true);
                }
            }
        });








































        // controlPanel.add(filePanel);
        // controlPanel.add(toolPanel);
        // controlPanel.add(roomPanel);
        // controlPanel.add(doorPanel);
        // controlPanel.add(windowPanel);
        // controlPanel.add(furniturePanel);
        // controlPanel.add(fixturePanel);
        controlPanel.setLayout(null);

        frame.add(controlPanel);
        frame.add(canvasPanel);

        frame.revalidate();
        frame.repaint();

        // newRoom.revalidate();
        // newRoom.repaint();
        // newRoom.setBounds(20, 31, 150, 30);

        frame.setLayout(null);

        frame.setVisible(true);
   }















//    public void OpenFile() {

//        JFileChooser fileChooser = new JFileChooser();
//        int option = fileChooser.showOpenDialog(frame);

//        if (option == JFileChooser.APPROVE_OPTION)
//        {
//            File file = fileChooser.getSelectedFile();
//            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//                textArea.read(reader, null);
//            }
//            catch (IOException ex) {
//            JOptionPane.showMessageDialog(frame, "File could not be opened", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//     }

//    public void SaveFile() {

//         JFileChooser fileChooser = new JFileChooser();
//         int option = fileChooser.showSaveDialog(frame);

//         if (option == JFileChooser.APPROVE_OPTION) {
//             File file = fileChooser.getSelectedFile();
//             try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
//                 textArea.write(writer);
//             }
//             catch (IOException ex) {
//                 JOptionPane.showMessageDialog(frame, "File could not be saved", "Error", JOptionPane.ERROR_MESSAGE);
//             }
//         }
//    }

//    public void NewPlanFile() {

//     int confirm = JOptionPane.showConfirmDialog(frame, "Do you want to save the current content?", "New File", JOptionPane.YES_NO_CANCEL_OPTION);
    
//     if (confirm == JOptionPane.YES_OPTION) {
//         SaveFile();
//     }
//     if (confirm == JOptionPane.YES_OPTION || confirm == JOptionPane.NO_OPTION) {
//         textArea.setText("");
//     }
//     }















    public static void main(String[] args) {
        PseudoProject p1 = new PseudoProject();
    }























    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getSource() == canvasPanel) {
            for(int i = 0; i < roomNum; i++) {
                rooms.get(i).setBorder(BorderFactory.createLineBorder(Color.black, 2));
            }
            return ;
        }

        JPanel temppanel = (JPanel)e.getSource();

        for(int i = 0; i < roomNum; i++) {
            rooms.get(i).setBorder(BorderFactory.createLineBorder(Color.black, 2));
        }

        temppanel.setBorder(BorderFactory.createLineBorder(new Color(0xADD8E6), 2));
    }

    @Override
    public void mousePressed(MouseEvent e) {
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

























    public void Addroom(int l, int b, String roomType)
    {
        if(xCoord + b > floor.getWidth())
        {
            yCoord = yCoordMax;
            yCoordMax = yCoordMax + l;
            xCoord = 0;
        }







        rooms.add(new JPanel());
        // rooms.get(roomNum).setPreferredSize(new Dimension(b, l));
        rooms.get(roomNum).setBounds(xCoord, yCoord, b, l);
        rooms.get(roomNum).addMouseListener(this);
        rooms.get(roomNum).setVisible(true);


        xCoord = xCoord + b;
        yCoordMax = Math.max(yCoordMax, l);

        
        switch (roomType){
            case "Bedroom":
            rooms.get(roomNum).setBackground(new Color(0x89E894));
            break;
            case "Bathroom":
            rooms.get(roomNum).setBackground(new Color(0x87CEFB));
            break;
            case "Kitchen":
            rooms.get(roomNum).setBackground(new Color(0xFF474C));
            break;
            case "Dining Room":
            rooms.get(roomNum).setBackground(new Color(0xffa500));
            break;
            case "Drawing Room":
            rooms.get(roomNum).setBackground(Color.YELLOW);
            break;
        }
        
        
        
        rooms.get(roomNum).setBorder(BorderFactory.createLineBorder(Color.black, 2));
        floor.add(rooms.get(roomNum),Integer.valueOf(2));
        roomNum++;

        System.out.println(roomType + " - " + l + " " + b);

        floor.revalidate();
        floor.repaint();
    }
}
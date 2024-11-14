import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// public class PseudoProject implements ActionListener{
public class PseudoProject{

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
        floor.setBounds(70,70,400,400);
        floor.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        canvasPanel.add(floor);


        // NewPlan.addActionListener(e -> NewPlanFile());
        // Open.addActionListener(e -> OpenFile());
        // Save.addActionListener(e -> SaveFile());


// Vikrant

































        NewPlan = new JButton("New Plan");
        NewPlan.setFocusable(false);
        // NewPlan.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        Open = new JButton("Open");
        Open.setFocusable(false);
        Save = new JButton("Save");
        Save.setFocusable(false);

        NewPlan.setBounds(50, 6, 150, 23);
        Open.setBounds(50, 35, 150, 23);
        Save.setBounds(50, 64, 150, 23);
        filePanel.add(NewPlan);
        filePanel.add(Open);
        filePanel.add(Save);

        filePanel.setLayout(null);









        newRoom = new JButton("New Room         +");
        newRoom.setFocusable(false);
        newRoom.setBounds(20, 31, 200, 40);
        // newRoom.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        roomPanel.add(newRoom);
        roomPanel.setLayout(null);
        // newRoom.revalidate();
        // newRoom.repaint();

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

                    l1.setBounds(50, 80, 100, 30);
                    l2.setBounds(50, 120, 100, 30);

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

        frame.revalidate();
        frame.repaint();

        // newRoom.revalidate();
        // newRoom.repaint();
        newRoom.setBounds(20, 31, 150, 30);

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
        JPanel j1 = new JPanel();
        j1.setPreferredSize(new Dimension(100, 100));
        PseudoProject p1 = new PseudoProject();
    }

    // @Override
    // public void actionPerformed(ActionEvent e) {
    //     if(e.getSource() == newRoom)
    //     {
    //         System.out.println("Hello");
    //     }
    // }

    public void Addroom(int l, int b, String roomType)
    {
        rooms.add(new JPanel());
        rooms.get(roomNum).setPreferredSize(new Dimension(b, l));
        rooms.get(roomNum).setVisible(true);
        switch (roomType){
            case "Bedroom":
            rooms.get(roomNum).setBackground(Color.GREEN);
            break;
            case "Bathroom":
            rooms.get(roomNum).setBackground(Color.BLUE);
            break;
            case "Kitchen":
            rooms.get(roomNum).setBackground(Color.RED);
            break;
            case "Dining Room":
            rooms.get(roomNum).setBackground(Color.ORANGE);
            break;
            case "Drawing Room":
            rooms.get(roomNum).setBackground(Color.YELLOW);
            break;
        }
        
        
        
        rooms.get(roomNum).setBorder(BorderFactory.createLineBorder(Color.black, 2));
        floor.add(rooms.get(roomNum),Integer.valueOf(2));
        roomNum++;

        // System.out.println(roomType + " - " + l + " " + b);

        floor.revalidate();
        floor.repaint();
    }
}
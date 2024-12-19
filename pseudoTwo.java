import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class pseudoTwo implements MouseListener {

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
    JPanel selectedRoom;
    Point initialClick;
    Point PrevCoord;

    public pseudoTwo() {

        frame = new JFrame("2D Floor Planner");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(null);

        frame.setVisible(true);

        frameHeight = frame.getHeight();
        frameWidth = frame.getWidth();

        Border border = BorderFactory.createLineBorder(Color.black, 3);

        // Maximum frame = ~1280x775

        controlPanel = new JPanel();
        canvasPanel = new JPanel();

        // Canvas Panel

        canvasPanel.setBounds(((frameWidth - 30) / 4) + 20, 10, (((frameWidth - 30) * 3) / 4), (frameHeight - 50));
        // canvasPanel.setBounds(333, 10, 935, 725);
        canvasPanel.setBackground(Color.lightGray);
        canvasPanel.setBorder(border);
        canvasPanel.addMouseListener(this);
        canvasPanel.setLayout(null);

        // Control Panel

        controlPanel.setBounds(10, 10, ((frameWidth - 30) / 4), (frameHeight - 50));
        // controlPanel.setBounds(10, 10, 313, 725);
        controlPanel.setBackground(new Color(0xffdc44));
        controlPanel.setBorder(border);

        // JPanel filePanel = new JPanel();
        // filePanel.setBounds(30, 10, 253, 92);
        // filePanel.setBackground(new Color(0xFFFFFF));
        // filePanel.setBorder(border);

        // JLabel newFile = new JLabel();
        // ImageIcon ifile = new ImageIcon("ifile.jpg");
        // newFile.setIcon(ifile);
        // filePanel.add(newFile);

        // JPanel toolPanel = new JPanel();
        // toolPanel.setBounds(30, 112, 253, 92);
        // toolPanel.setBackground(new Color(0xFFFFFF));
        // toolPanel.setBorder(border);

        // JPanel roomPanel = new JPanel();
        // roomPanel.setBounds(30, 214, 253, 92);
        // roomPanel.setBackground(new Color(0xFFFFFF));
        // roomPanel.setBorder(border);

        // JPanel doorPanel = new JPanel();
        // doorPanel.setBounds(30, 316, 253, 92);
        // doorPanel.setBackground(new Color(0xFFFFFF));
        // doorPanel.setBorder(border);

        // JPanel windowPanel = new JPanel();
        // windowPanel.setBounds(30, 418, 253, 92);
        // windowPanel.setBackground(new Color(0xFFFFFF));
        // windowPanel.setBorder(border);

        // JPanel furniturePanel = new JPanel();
        // furniturePanel.setBounds(30, 520, 253, 92);
        // furniturePanel.setBackground(new Color(0xFFFFFF));
        // furniturePanel.setBorder(border);

        // JPanel fixturePanel = new JPanel();
        // fixturePanel.setBounds(30, 622, 253, 92);
        // fixturePanel.setBackground(new Color(0xFFFFFF));
        // fixturePanel.setBorder(border);

        floor = new JLayeredPane();
        floor.setBorder(border);
        floor.setBounds(70, 70, (((frameWidth - 30) * 3) / 4) - 140, (frameHeight - 50) - 140);
        floor.setLayout(null);
        // floor.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));

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

                    if (isSelected()) {
                        // System.out.println("Yes");

                        JDialog dialog = new JDialog(frame, "Room Type 2");

                        JTextField text1 = new JTextField();
                        JTextField text2 = new JTextField();

                        String roomName[] = { "Bedroom", "Bathroom", "Kitchen", "Dining Room", "Drawing Room" };

                        JComboBox roomType = new JComboBox(roomName);

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

                    else {

                        JDialog dialog = new JDialog(frame, "Room Type");

                        JTextField text1 = new JTextField();
                        JTextField text2 = new JTextField();

                        String roomName[] = { "Bedroom", "Bathroom", "Kitchen", "Dining Room", "Drawing Room" };

                        JComboBox roomType = new JComboBox(roomName);

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

    // public void OpenFile() {

    // JFileChooser fileChooser = new JFileChooser();
    // int option = fileChooser.showOpenDialog(frame);

    // if (option == JFileChooser.APPROVE_OPTION)
    // {
    // File file = fileChooser.getSelectedFile();
    // try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
    // textArea.read(reader, null);
    // }
    // catch (IOException ex) {
    // JOptionPane.showMessageDialog(frame, "File could not be opened", "Error",
    // JOptionPane.ERROR_MESSAGE);
    // }
    // }
    // }

    // public void SaveFile() {

    // JFileChooser fileChooser = new JFileChooser();
    // int option = fileChooser.showSaveDialog(frame);

    // if (option == JFileChooser.APPROVE_OPTION) {
    // File file = fileChooser.getSelectedFile();
    // try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
    // textArea.write(writer);
    // }
    // catch (IOException ex) {
    // JOptionPane.showMessageDialog(frame, "File could not be saved", "Error",
    // JOptionPane.ERROR_MESSAGE);
    // }
    // }
    // }

    // public void NewPlanFile() {

    // int confirm = JOptionPane.showConfirmDialog(frame, "Do you want to save the
    // current content?", "New File", JOptionPane.YES_NO_CANCEL_OPTION);

    // if (confirm == JOptionPane.YES_OPTION) {
    // SaveFile();
    // }
    // if (confirm == JOptionPane.YES_OPTION || confirm == JOptionPane.NO_OPTION) {
    // textArea.setText("");
    // }
    // }

    public static void main(String[] args) {
        pseudoTwo p1 = new pseudoTwo();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == canvasPanel) {
            for (int i = 0; i < roomNum; i++) {
                rooms.get(i).setBorder(BorderFactory.createLineBorder(Color.black, 2));
            }
            return;
        }

        JPanel temppanel = (JPanel) e.getSource();

        for (int i = 0; i < roomNum; i++) {
            rooms.get(i).setBorder(BorderFactory.createLineBorder(Color.black, 2));
        }

        temppanel.setBorder(BorderFactory.createLineBorder(new Color(0xADD8E6), 2));
    }

    @Override
    public void mousePressed(MouseEvent e) {
        PrevCoord = ((JPanel) e.getSource()).getLocation();
        initialClick = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if (!OverlapCheck((JPanel) e.getSource())) {
            JOptionPane.showMessageDialog(frame, "Room can't be placed", "Overlapping", JOptionPane.ERROR_MESSAGE);
            ((JPanel) e.getSource()).setLocation(PrevCoord);
        }

        if (!BoundaryCheck((JPanel) e.getSource())) {
            JOptionPane.showMessageDialog(frame, "Room can't be placed", "Room Out Of Bound",
                    JOptionPane.ERROR_MESSAGE);
            ((JPanel) e.getSource()).setLocation(PrevCoord);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void Addroom(int l, int b, String roomType) {
        // if (isSelected()) {
        // System.out.println("Yes");
        // }

        // else {

        if (xCoord + b > floor.getWidth()) {
            yCoord = yCoordMax;
            yCoordMax = yCoordMax + l;
            xCoord = 0;
        }

        rooms.add(new JPanel());
        // rooms.get(roomNum).setPreferredSize(new Dimension(b, l));
        rooms.get(roomNum).setBounds(xCoord, yCoord, b, l);
        rooms.get(roomNum).addMouseListener(this);
        rooms.get(roomNum).setVisible(true);

        // rooms.get(roomNum).addMouseListener(new MouseAdapter() {
        // @Override
        // public void mousePressed(MouseEvent e) {
        // // initialClick = e.getPoint(); // Store the initial click location
        // // System.out.println("Hi");
        // }
        // });

        rooms.get(roomNum).addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int thisX = ((JPanel) e.getSource()).getX();
                int thisY = ((JPanel) e.getSource()).getY();

                int xMoved = e.getX() - initialClick.x;
                int yMoved = e.getY() - initialClick.y;

                int newX = thisX + xMoved;
                int newY = thisY + yMoved;

                ((JPanel) e.getSource()).setLocation(newX, newY);
            }
        });

        xCoord = xCoord + b;
        yCoordMax = Math.max(yCoordMax, l);
        // yCoordMax++;

        switch (roomType) {
            case "Bedroom":
                rooms.get(roomNum).setBackground(new Color(0x99DD5C)); // Green
                // rooms.get(roomNum).setBorder(BorderFactory.createLineBorder(new
                // Color(0x30A130), 2));
                break;
            case "Bathroom":
                rooms.get(roomNum).setBackground(new Color(0x0050FF)); // Blue
                break;
            case "Kitchen":
                rooms.get(roomNum).setBackground(new Color(0xFF1515)); // Red
                break;
            case "Dining Room":
                rooms.get(roomNum).setBackground(new Color(0xFF7700)); // Orange
                break;
            case "Drawing Room":
                rooms.get(roomNum).setBackground(Color.YELLOW); // Yellow
                break;
        }

        rooms.get(roomNum).setBorder(BorderFactory.createLineBorder(Color.black, 2));
        floor.add(rooms.get(roomNum), Integer.valueOf(2));
        roomNum++;

        System.out.println(roomType + " - " + l + " " + b);

        floor.revalidate();
        floor.repaint();
        // }
    }

    public boolean OverlapCheck(JPanel p) {
        if (!p.equals(canvasPanel)) {
            Point fir01 = p.getLocation();
            Point fir10 = new Point(fir01.x + p.getWidth(), fir01.y + p.getHeight());

            for (int i = 0; i < roomNum; i++) {
                if (rooms.get(i) == p)
                    continue;
                else {
                    Point sec01 = rooms.get(i).getLocation();
                    Point sec10 = new Point(sec01.x + rooms.get(i).getWidth(), sec01.y + rooms.get(i).getHeight());

                    if (fir01.x >= sec10.x || sec01.x >= fir10.x || fir01.y >= sec10.y || sec01.y >= fir10.y)
                        ;
                    else
                        return false;
                }
            }
        }
        return true;
    }

    public boolean BoundaryCheck(JPanel p) {
        if (!p.equals(canvasPanel)) {
            Point new01 = p.getLocation();
            Point new10 = new Point(new01.x + p.getWidth(), new01.y + p.getHeight());

            if (new01.x < 0 || new01.y < 0 || new10.x > (((frameWidth - 30) * 3) / 4) - 140
                    || (frameHeight - 50) - 140 < new10.y)
                return false;
        }
        return true;
    }

    public boolean isSelected() {
        // System.out.println("coorect");
        for (int i = 0; i < roomNum; i++) {
            if (!(((LineBorder) rooms.get(i).getBorder()).getLineColor()).equals(new Color(0xADD8E6))) {
                // System.out.println(((LineBorder) rooms.get(i).getBorder()).getLineColor() + " " + (new Color(0xADD8E6)));
                continue;
            }
            else
                return true;
        }
        return false;
    }
}
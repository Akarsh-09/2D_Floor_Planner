// import javax.swing.*;
// import javax.swing.border.Border;
// import java.awt.*;
// import java.awt.event.*;
// import java.util.ArrayList;

// public class AddingRoom implements ActionListener {
//     private JFrame frame;
//     private JPanel floor;
//     private ArrayList<JPanel> rooms = new ArrayList<>();
//     private JButton addRoomButton;
//     private int roomNum = 0;

//     public AddingRoom() {
//         frame = new JFrame("2D Floor Planner");
//         frame.setSize(800, 600);
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setLayout(null);

//         // Floor panel with custom layout manager
//         floor = new JPanel(new RowMajorLayout());
//         floor.setBounds(50, 50, 500, 500);
//         floor.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
//         frame.add(floor);

//         addRoomButton = new JButton("Add Room");
//         addRoomButton.setBounds(50, 10, 100, 30);
//         addRoomButton.addActionListener(this);
//         frame.add(addRoomButton);

//         frame.setVisible(true);
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(AddingRoom::new);
//     }

//     @Override
//     public void actionPerformed(ActionEvent e) {
//         if (e.getSource() == addRoomButton) {
//             addRoom();
//         }
//     }

//     private void addRoom() {
//         // Create a new panel with varying size
//         int panelWidth = 50 + (int) (Math.random() * 100);
//         int panelHeight = 50 + (int) (Math.random() * 100);
//         JPanel roomPanel = new JPanel();
//         roomPanel.setPreferredSize(new Dimension(panelWidth, panelHeight));
//         roomPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//         roomPanel.setBackground(new Color((int) (Math.random() * 0x1000000)));

//         // Add room to floor panel
//         rooms.add(roomPanel);
//         floor.add(roomPanel);
//         floor.revalidate();
//         floor.repaint();
//     }

//     /**
//      * Custom layout manager for row-major arrangement of components.
//      */
//     private static class RowMajorLayout implements LayoutManager {
//         private int gap = 10;  // Gap between panels

//         @Override
//         public void addLayoutComponent(String name, Component comp) {}

//         @Override
//         public void removeLayoutComponent(Component comp) {}

//         @Override
//         public Dimension preferredLayoutSize(Container parent) {
//             return calculateSize(parent);
//         }

//         @Override
//         public Dimension minimumLayoutSize(Container parent) {
//             return calculateSize(parent);
//         }

//         @Override
//         public void layoutContainer(Container parent) {
//             int width = parent.getWidth();
//             int x = 0, y = 0, rowHeight = 0;

//             for (Component comp : parent.getComponents()) {
//                 Dimension compSize = comp.getPreferredSize();

//                 // Wrap to the next row if component exceeds panel width
//                 if (x + compSize.width > width) {
//                     x = 0;
//                     y += rowHeight + gap;
//                     rowHeight = 0;
//                 }

//                 // Set component bounds and update x position and row height
//                 comp.setBounds(x, y, compSize.width, compSize.height);
//                 x += compSize.width + gap;
//                 rowHeight = Math.max(rowHeight, compSize.height);
//             }
//         }

//         private Dimension calculateSize(Container parent) {
//             int width = 0;
//             int height = 0;
//             int rowWidth = 0;
//             int rowHeight = 0;

//             for (Component comp : parent.getComponents()) {
//                 Dimension compSize = comp.getPreferredSize();

//                 if (rowWidth + compSize.width > parent.getWidth()) {
//                     // New row, add accumulated row height to total height
//                     height += rowHeight + gap;
//                     width = Math.max(width, rowWidth);
//                     rowWidth = 0;
//                     rowHeight = 0;
//                 }

//                 rowWidth += compSize.width + gap;
//                 rowHeight = Math.max(rowHeight, compSize.height);
//             }

//             // Add last row height
//             height += rowHeight;
//             width = Math.max(width, rowWidth);

//             return new Dimension(width, height);
//         }
//     }
// }






// import javax.swing.*;
// import javax.swing.border.Border;
// import java.awt.*;
// import java.awt.event.*;
// import java.util.ArrayList;

// public class AddingRoom implements ActionListener {
//     private JFrame frame;
//     private JPanel floor;
//     private ArrayList<JPanel> rooms = new ArrayList<>();
//     private JButton addRoomButton;
//     private int roomNum = 0;

//     public AddingRoom() {
//         frame = new JFrame("2D Floor Planner");
//         frame.setSize(800, 600);
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setLayout(null);

//         // Floor panel with custom layout manager
//         floor = new JPanel(new RowMajorLayout());
//         floor.setBounds(50, 50, 500, 500);
//         floor.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
//         frame.add(floor);

//         addRoomButton = new JButton("Add Room");
//         addRoomButton.setBounds(50, 10, 100, 30);
//         addRoomButton.addActionListener(this);
//         frame.add(addRoomButton);

//         frame.setVisible(true);
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(AddingRoom::new);
//     }

//     @Override
//     public void actionPerformed(ActionEvent e) {
//         if (e.getSource() == addRoomButton) {
//             addRoom();
//         }
//     }

//     private void addRoom() {
//         // Show dialog to enter room dimensions
//         JTextField widthField = new JTextField(5);
//         JTextField heightField = new JTextField(5);

//         JPanel inputPanel = new JPanel();
//         inputPanel.add(new JLabel("Width:"));
//         inputPanel.add(widthField);
//         inputPanel.add(Box.createHorizontalStrut(15)); // Spacing
//         inputPanel.add(new JLabel("Height:"));
//         inputPanel.add(heightField);

//         int result = JOptionPane.showConfirmDialog(null, inputPanel,
//                 "Enter Room Dimensions", JOptionPane.OK_CANCEL_OPTION);
//         if (result == JOptionPane.OK_OPTION) {
//             try {
//                 int panelWidth = Integer.parseInt(widthField.getText());
//                 int panelHeight = Integer.parseInt(heightField.getText());

//                 // Create the room panel with specified dimensions
//                 JPanel roomPanel = new JPanel();
//                 roomPanel.setPreferredSize(new Dimension(panelWidth, panelHeight));
//                 roomPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//                 roomPanel.setBackground(new Color((int) (Math.random() * 0x1000000)));

//                 // Add room to floor panel
//                 rooms.add(roomPanel);
//                 floor.add(roomPanel);
//                 floor.revalidate();
//                 floor.repaint();
//             } catch (NumberFormatException ex) {
//                 JOptionPane.showMessageDialog(frame, "Please enter valid integers for width and height.",
//                         "Invalid Input", JOptionPane.ERROR_MESSAGE);
//             }
//         }
//     }

//     /**
//      * Custom layout manager for row-major arrangement of components.
//      */
//     private static class RowMajorLayout implements LayoutManager {
//         private int gap = 0;  // Gap between panels

//         @Override
//         public void addLayoutComponent(String name, Component comp) {}

//         @Override
//         public void removeLayoutComponent(Component comp) {}

//         @Override
//         public Dimension preferredLayoutSize(Container parent) {
//             return calculateSize(parent);
//         }

//         @Override
//         public Dimension minimumLayoutSize(Container parent) {
//             return calculateSize(parent);
//         }

//         @Override
//         public void layoutContainer(Container parent) {
//             int width = parent.getWidth();
//             int x = 0, y = 0, rowHeight = 0;

//             for (Component comp : parent.getComponents()) {
//                 Dimension compSize = comp.getPreferredSize();

//                 // Wrap to the next row if component exceeds panel width
//                 if (x + compSize.width > width) {
//                     x = 0;
//                     y += rowHeight + gap;
//                     rowHeight = 0;
//                 }

//                 // Set component bounds and update x position and row height
//                 comp.setBounds(x, y, compSize.width, compSize.height);
//                 x += compSize.width + gap;
//                 rowHeight = Math.max(rowHeight, compSize.height);
//             }
//         }

//         private Dimension calculateSize(Container parent) {
//             int width = 0;
//             int height = 0;
//             int rowWidth = 0;
//             int rowHeight = 0;

//             for (Component comp : parent.getComponents()) {
//                 Dimension compSize = comp.getPreferredSize();

//                 if (rowWidth + compSize.width > parent.getWidth()) {
//                     // New row, add accumulated row height to total height
//                     height += rowHeight + gap;
//                     width = Math.max(width, rowWidth);
//                     rowWidth = 0;
//                     rowHeight = 0;
//                 }

//                 rowWidth += compSize.width + gap;
//                 rowHeight = Math.max(rowHeight, compSize.height);
//             }

//             // Add last row height
//             height += rowHeight;
//             width = Math.max(width, rowWidth);

//             return new Dimension(width, height);
//         }
//     }
// }






// import javax.swing.*;
// import javax.swing.border.Border;
// import java.awt.*;
// import java.awt.event.*;
// import java.util.ArrayList;

// public class AddingRoom implements ActionListener {
//     private JFrame frame;
//     private JPanel floor;
//     private ArrayList<JPanel> rooms = new ArrayList<>();
//     private JButton addRoomButton;
//     private int roomNum = 0;
//     private JPanel selectedRoom;
//     private Point initialClick;

//     public AddingRoom() {
//         frame = new JFrame("2D Floor Planner");
//         frame.setSize(800, 600);
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setLayout(null);

//         // Floor panel with custom layout manager
//         floor = new JPanel(new RowMajorLayout());
//         floor.setLayout(new RowMajorLayout());
//         floor.setBounds(50, 50, 500, 500);
//         floor.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
//         frame.add(floor);

//         addRoomButton = new JButton("Add Room");
//         addRoomButton.setBounds(50, 10, 100, 30);
//         addRoomButton.addActionListener(this);
//         frame.add(addRoomButton);

//         frame.setVisible(true);
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(AddingRoom::new);
//     }

//     @Override
//     public void actionPerformed(ActionEvent e) {
//         if (e.getSource() == addRoomButton) {
//             addRoom();
//         }
//     }

//     private void addRoom() {
//         // Show dialog to enter room dimensions
//         JTextField widthField = new JTextField(5);
//         JTextField heightField = new JTextField(5);

//         JPanel inputPanel = new JPanel();
//         inputPanel.add(new JLabel("Width:"));
//         inputPanel.add(widthField);
//         inputPanel.add(Box.createHorizontalStrut(15)); // Spacing
//         inputPanel.add(new JLabel("Height:"));
//         inputPanel.add(heightField);

//         int result = JOptionPane.showConfirmDialog(null, inputPanel,
//                 "Enter Room Dimensions", JOptionPane.OK_CANCEL_OPTION);
//         if (result == JOptionPane.OK_OPTION) {
//             try {
//                 int panelWidth = Integer.parseInt(widthField.getText());
//                 int panelHeight = Integer.parseInt(heightField.getText());

//                 // Create the room panel with specified dimensions
//                 JPanel roomPanel = new JPanel();
//                 roomPanel.setPreferredSize(new Dimension(panelWidth, panelHeight));
//                 roomPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//                 roomPanel.setBackground(new Color((int) (Math.random() * 0x1000000)));

//                 // Add mouse listeners for dragging functionality
//                 roomPanel.addMouseListener(new MouseAdapter() {
//                     @Override
//                     public void mousePressed(MouseEvent e) {
//                         selectedRoom = roomPanel;
//                         initialClick = e.getPoint();
//                     }
//                 });

//                 roomPanel.addMouseMotionListener(new MouseAdapter() {
//                     @Override
//                     public void mouseDragged(MouseEvent e) {
//                         moveRoom(e);
//                     }
//                 });

//                 // Add room to floor panel
//                 rooms.add(roomPanel);
//                 floor.add(roomPanel);
//                 floor.revalidate();
//                 floor.repaint();
//             } catch (NumberFormatException ex) {
//                 JOptionPane.showMessageDialog(frame, "Please enter valid integers for width and height.",
//                         "Invalid Input", JOptionPane.ERROR_MESSAGE);
//             }
//         }
//         floor.setLayout(new RowMajorLayout());
//     }

//     private void moveRoom(MouseEvent e) {
//         if (selectedRoom != null) {
            
//             // Temporarily set floor layout to null for free dragging
//             floor.setLayout(null);

//             // Calculate the new location
//             int thisX = selectedRoom.getX();
//             int thisY = selectedRoom.getY();

//             // Get the offset based on initial click
//             int xMoved = e.getX() - initialClick.x;
//             int yMoved = e.getY() - initialClick.y;

//             // Move the room to the new location
//             int newX = thisX + xMoved;
//             int newY = thisY + yMoved;
//             selectedRoom.setLocation(newX, newY);

//             // Refresh the container to show the updated location
//             floor.revalidate();
//             floor.repaint();
//         }
//     }

//     /**
//      * Custom layout manager for row-major arrangement of components.
//      */
//     private static class RowMajorLayout implements LayoutManager {
//         private int gap = 0;  // Gap between panels

//         @Override
//         public void addLayoutComponent(String name, Component comp) {}

//         @Override
//         public void removeLayoutComponent(Component comp) {}

//         @Override
//         public Dimension preferredLayoutSize(Container parent) {
//             return calculateSize(parent);
//         }

//         @Override
//         public Dimension minimumLayoutSize(Container parent) {
//             return calculateSize(parent);
//         }

//         @Override
//         public void layoutContainer(Container parent) {
//             int width = parent.getWidth();
//             int x = 0, y = 0, rowHeight = 0;

//             for (Component comp : parent.getComponents()) {
//                 Dimension compSize = comp.getPreferredSize();

//                 // Wrap to the next row if component exceeds panel width
//                 if (x + compSize.width > width) {
//                     x = 0;
//                     y += rowHeight + gap;
//                     rowHeight = 0;
//                 }

//                 // Set component bounds and update x position and row height
//                 comp.setBounds(x, y, compSize.width, compSize.height);
//                 x += compSize.width + gap;
//                 rowHeight = Math.max(rowHeight, compSize.height);
//             }
//         }

//         private Dimension calculateSize(Container parent) {
//             int width = 0;
//             int height = 0;
//             int rowWidth = 0;
//             int rowHeight = 0;

//             for (Component comp : parent.getComponents()) {
//                 Dimension compSize = comp.getPreferredSize();

//                 if (rowWidth + compSize.width > parent.getWidth()) {
//                     // New row, add accumulated row height to total height
//                     height += rowHeight + gap;
//                     width = Math.max(width, rowWidth);
//                     rowWidth = 0;
//                     rowHeight = 0;
//                 }

//                 rowWidth += compSize.width + gap;
//                 rowHeight = Math.max(rowHeight, compSize.height);
//             }

//             // Add last row height
//             height += rowHeight;
//             width = Math.max(width, rowWidth);

//             return new Dimension(width, height);
//         }
//     }
// }






import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AddingRoom implements ActionListener {
    private JFrame frame;
    private JPanel floor;
    private ArrayList<JPanel> rooms = new ArrayList<>();
    private JButton addRoomButton;
    private int roomNum = 0;
    private JPanel selectedRoom;
    private Point initialClick;

    public AddingRoom() {
        frame = new JFrame("2D Floor Planner");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Floor panel with RowMajorLayout initially
        floor = new JPanel(new RowMajorLayout());
        floor.setBounds(50, 50, 500, 500);
        floor.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        frame.add(floor);

        addRoomButton = new JButton("Add Room");
        addRoomButton.setBounds(50, 10, 100, 30);
        addRoomButton.addActionListener(this);
        frame.add(addRoomButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AddingRoom::new);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addRoomButton) {
            addRoom();
        }
    }

    private void addRoom() {
        // Show dialog to enter room dimensions
        JTextField widthField = new JTextField(5);
        JTextField heightField = new JTextField(5);

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Width:"));
        inputPanel.add(widthField);
        inputPanel.add(Box.createHorizontalStrut(15)); // Spacing
        inputPanel.add(new JLabel("Height:"));
        inputPanel.add(heightField);

        int result = JOptionPane.showConfirmDialog(null, inputPanel, "Enter Room Dimensions", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                int panelWidth = Integer.parseInt(widthField.getText());
                int panelHeight = Integer.parseInt(heightField.getText());

                // Create the room panel with specified dimensions
                JPanel roomPanel = new JPanel();
                roomPanel.setPreferredSize(new Dimension(panelWidth, panelHeight));
                roomPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                roomPanel.setBackground(new Color((int) (Math.random() * 0x1000000)));

                // Add mouse listeners for dragging functionality
                roomPanel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        selectedRoom = roomPanel;
                        initialClick = e.getPoint();
                    }
                });

                roomPanel.addMouseMotionListener(new MouseAdapter() {
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        moveRoom(e);
                    }
                });

                // Add room to floor panel
                rooms.add(roomPanel);
                floor.add(roomPanel);

                // If it's the first room, set the layout manager to RowMajorLayout, 
                // otherwise, switch to null layout for absolute positioning
                if (rooms.size() == 1) {
                    floor.setLayout(new RowMajorLayout());
                } else {
                    floor.setLayout(null);  // Switch to null layout for free dragging
                    roomPanel.setBounds(roomPanel.getLocation().x, roomPanel.getLocation().y, 
                                        panelWidth, panelHeight);
                }

                floor.revalidate();
                floor.repaint();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid integers for width and height.",
                        "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void moveRoom(MouseEvent e) {
        if (selectedRoom != null) {
            // Temporarily set floor layout to null for free dragging
            floor.setLayout(null);

            // Calculate the new location
            int thisX = selectedRoom.getX();
            int thisY = selectedRoom.getY();

            // Get the offset based on initial click
            int xMoved = e.getX() - initialClick.x;
            int yMoved = e.getY() - initialClick.y;

            // Move the room to the new location
            int newX = thisX + xMoved;
            int newY = thisY + yMoved;
            selectedRoom.setLocation(newX, newY);

            // Refresh the container to show the updated location
            floor.revalidate();
            floor.repaint();
        }
    }

    /**
     * Custom layout manager for row-major arrangement of components.
     */
    private static class RowMajorLayout implements LayoutManager {
        private int gap = 0;  // Gap between panels

        @Override
        public void addLayoutComponent(String name, Component comp) {}

        @Override
        public void removeLayoutComponent(Component comp) {}

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            return calculateSize(parent);
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            return calculateSize(parent);
        }

        @Override
        public void layoutContainer(Container parent) {
            int width = parent.getWidth();
            int x = 0, y = 0, rowHeight = 0;

            for (Component comp : parent.getComponents()) {
                Dimension compSize = comp.getPreferredSize();

                // Wrap to the next row if component exceeds panel width
                if (x + compSize.width > width) {
                    x = 0;
                    y += rowHeight + gap;
                    rowHeight = 0;
                }

                // Set component bounds and update x position and row height
                comp.setBounds(x, y, compSize.width, compSize.height);
                x += compSize.width + gap;
                rowHeight = Math.max(rowHeight, compSize.height);
            }
        }

        private Dimension calculateSize(Container parent) {
            int width = 0;
            int height = 0;
            int rowWidth = 0;
            int rowHeight = 0;

            for (Component comp : parent.getComponents()) {
                Dimension compSize = comp.getPreferredSize();

                if (rowWidth + compSize.width > parent.getWidth()) {
                    // New row, add accumulated row height to total height
                    height += rowHeight + gap;
                    width = Math.max(width, rowWidth);
                    rowWidth = 0;
                    rowHeight = 0;
                }

                rowWidth += compSize.width + gap;
                rowHeight = Math.max(rowHeight, compSize.height);
            }

            // Add last row height
            height += rowHeight;
            width = Math.max(width, rowWidth);

            return new Dimension(width, height);
        }
    }
}
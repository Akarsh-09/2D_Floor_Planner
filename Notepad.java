import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Notepad {

    private JFrame frame;
    private JTextArea textArea;

    public Notepad() {
        frame = new JFrame("File Operations Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Text area for displaying file content or new content
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();

        // Create buttons
        JButton openButton = new JButton("Open");
        JButton saveButton = new JButton("Save");
        JButton newButton = new JButton("New");

        // Add ActionListeners for buttons
        openButton.addActionListener(e -> openFile());
        saveButton.addActionListener(e -> saveFile());
        newButton.addActionListener(e -> newFile());

        // Add buttons to panel
        buttonPanel.add(newButton);
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);

        // Add components to frame
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(frame);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                textArea.read(reader, null);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "File could not be opened", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(frame);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                textArea.write(writer);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "File could not be saved", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void newFile() {
        int confirm = JOptionPane.showConfirmDialog(frame, "Do you want to save the current content?", "New File", JOptionPane.YES_NO_CANCEL_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            saveFile();
        }
        if (confirm == JOptionPane.YES_OPTION || confirm == JOptionPane.NO_OPTION) {
            textArea.setText("");
        }
    }

    public static void main(String[] args) {
        Notepad n1 = new Notepad();
    }
}
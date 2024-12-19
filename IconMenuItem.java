import javax.swing.*;
import java.awt.event.*;

public class IconMenuItem extends JMenuItem {
    IconMenuItem(JPanel pan, String[] s, String text) {
        this.setText(text);

        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent f) {

                Icon ic = new Icon(s, pan);
                pan.setLayout(null);
            }
        });

    }
}
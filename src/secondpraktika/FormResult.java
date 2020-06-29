package secondpraktika;

import java.awt.*;
import javax.swing.*;

public class FormResult extends JFrame {
    JLabel l1 ,l2;

    public FormResult(String s, String resY, String resS) {
        super(s);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l1 = new JLabel("Итоговое значение Y: " + resY);
        l2 = new JLabel("Итоговое значение S: " + resS);
        add(l1);
        add(l2);
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Frame extends JFrame {
    Main_Frame(){

        setSize(600,300);
        Trigged triger = new Trigged();
        JButton button = new JButton("trigger (not Active)");

        add(button);
        addKeyListener(triger);
        setFocusable(true);

        ActionListener triggerListenel = new ActionListener() {
            boolean button_set = false;
            @Override
            public void actionPerformed(ActionEvent e) {
                triger.trigger_Active();
            }
        };

        button.addActionListener(triggerListenel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

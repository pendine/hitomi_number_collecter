import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Frame extends JFrame {
    final int repeat = 1;
    int getRepeat = 1;
    Main_Frame(){
        setSize(600,300);
        Trigged triger = new Trigged();
        JButton button = new JButton("trigger");
        JTextField jtf = new JTextField(getRepeat);
        JButton consoleLineEnterkey = new JButton("Console line enter key");

        add(jtf,BorderLayout.SOUTH);
        add(button);
        add(consoleLineEnterkey,BorderLayout.EAST);
        addKeyListener(triger);
        setFocusable(true);

        ActionListener triggerListenel = new ActionListener() {
            boolean button_set = false;
            @Override
            public void actionPerformed(ActionEvent e) {
                String tmp  = jtf.getText();
                getRepeat = Integer.parseInt(tmp);
                if(getRepeat >1){
                    for(int i=0; i<getRepeat; i++){
                        triger.trigger_Active();
                    }
                }else {
                    triger.trigger_Active();
                }
            }
        };
        button.addActionListener(triggerListenel);

        ActionListener consoleLineCarry = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("   ");
            }
        };
        consoleLineEnterkey.addActionListener(consoleLineCarry);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

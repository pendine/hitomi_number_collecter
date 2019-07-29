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
        jtf.setText(String.valueOf(getRepeat));
        add(jtf);
        setLayout(new GridLayout(3,2,10,10));
        add(button);
        add(consoleLineEnterkey);
        addKeyListener(triger);
        setFocusable(true);

        ActionListener triggerListenel = new ActionListener() {
            boolean button_set = false;
            @Override
            public void actionPerformed(ActionEvent e) {
                String tmp  = jtf.getText();
                if(tmp != null) {
                    getRepeat = Integer.parseInt(tmp);
                }else{
                    getRepeat = 1;
                }
                if(getRepeat >1){
                    for(int i=0; i<getRepeat; i++){
                        triger.trigger_Active();
                    }
                    jtf.setText(String.valueOf(repeat));
                }else {
                    triger.trigger_Active();
                    jtf.setText(String.valueOf(repeat));
                }
            }
        };
        button.addActionListener(triggerListenel);

        ActionListener consoleLineCarry = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("   ");
                triger.count= 0;
            }
        };
        consoleLineEnterkey.addActionListener(consoleLineCarry);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

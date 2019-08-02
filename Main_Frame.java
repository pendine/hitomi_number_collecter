import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Frame extends JFrame {
    final int repeat = 1;
    int getRepeat = 1;

    public void gridBagXYWidthHeight(GridBagConstraints target, int x, int y, int width, int height) {
        target.gridx = x;
        target.gridy = y;
        target.gridwidth = width;
        target.gridheight = height;
    }

    public void gridBagXYWidthHeight(GridBagConstraints target, int x, int y, int width, int height, boolean fill) {
        target.gridx = x;
        target.gridy = y;
        target.gridwidth = width;
        target.gridheight = height;
        if (fill) {
            target.fill = GridBagConstraints.BOTH;
        }
    }

    Main_Frame() {
        setSize(600, 300);
        Trigged triger = new Trigged();
        JButton button = new JButton("trigger");
        JButton consoleLineEnterkey = new JButton("Console line enter key");
        JButton number_init_button = new JButton("Printed Initializing");
        JTextArea numberPrintPanel = new JTextArea();

        JTextField jtf = new JTextField(getRepeat);
        jtf.setText(String.valueOf(getRepeat));

        numberPrintPanel.setEditable(false);
        numberPrintPanel.setDragEnabled(true);

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{1, 1, 1, 1, 1};
        gridBagLayout.rowHeights = new int[]{100, 100, 100};
        gridBagLayout.columnWeights = new double[]{1, 1, 30, 1, 1};
        gridBagLayout.rowWeights = new double[]{1, 1, 1};

        setLayout(gridBagLayout);

        //----------------------------------------------------------
        //-----------------Layout Position Setting------------------
        //----------------------------------------------------------
        GridBagConstraints gbjTextField = new GridBagConstraints();
        gridBagXYWidthHeight(gbjTextField, 0, 0, 2, 1, true);
        add(jtf, gbjTextField);

        GridBagConstraints gbButton = new GridBagConstraints();
        gridBagXYWidthHeight(gbButton, 0, 1, 2, 1, true);
        add(button, gbButton);

//        GridBagConstraints gbConsole = new GridBagConstraints();
//        gridBagXYWidthHeight(gbConsole, 0, 2, 1, 1, true);
//        add(consoleLineEnterkey, gbConsole);

        GridBagConstraints gbPrinter = new GridBagConstraints();
        gridBagXYWidthHeight(gbPrinter, 0, 2, 2, 1, true);
        add(number_init_button, gbPrinter);

        GridBagConstraints gbTextArea = new GridBagConstraints();
        gridBagXYWidthHeight(gbTextArea, 2, 0, 3, 3, true);
        add(numberPrintPanel, gbTextArea);


        //----------------------------------------------------------
        //-----------------Action Listenel Setting------------------
        //----------------------------------------------------------

        ActionListener triggerListenel = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tmp = jtf.getText();
                if (tmp != null && isStringNumber(tmp)) {
                    getRepeat = Integer.parseInt(tmp);
                } else {
                    getRepeat = 1;
                }
                if (getRepeat >= 1) {
                    triger.multi_Active(getRepeat, numberPrintPanel);
                    jtf.setText(String.valueOf(repeat));
                } else {
                    triger.multi_Active(repeat, numberPrintPanel);
                    jtf.setText(String.valueOf(repeat));
                }
            }
        };
        button.addActionListener(triggerListenel);

        ActionListener consoleLineCarry = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(" ");
                triger.count = 0;
                numberPrintPanel.append(" \n");
            }
        };
        consoleLineEnterkey.addActionListener(consoleLineCarry);


        ActionListener numberPrintInit = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberPrintPanel.setText(" ");
            }
        };
        number_init_button.addActionListener(numberPrintInit);


        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public boolean isStringNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}

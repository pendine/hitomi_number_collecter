import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Trigged extends Thread implements KeyListener {
    boolean flag = false;
    String tmp;
    Robot r;
    Thread wait = new Thread();

    public void trigger_Active() {
//        flag = !flag;
        try {
            r = new Robot();
        } catch (AWTException em) {
            em.printStackTrace();
        }

        try {
            r.keyPress(KeyEvent.VK_ALT);
            r.keyPress(KeyEvent.VK_TAB);
            r.keyRelease(KeyEvent.VK_TAB);
            r.keyRelease(KeyEvent.VK_ALT);

            Thread.sleep(150);

            r.keyPress(KeyEvent.VK_F6);
            r.keyRelease(KeyEvent.VK_F6);

            Thread.sleep(150);

            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_C);
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.keyRelease(KeyEvent.VK_C);

            Thread.sleep(150);

            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable data = clipboard.getContents(this);
            tmp = (String) data.getTransferData(DataFlavor.stringFlavor);
            String aaa = getString(tmp);
            aaa=aaa+" ";
            System.out.print(aaa);
//            new Save_Write_Number().saveNumber(aaa);

            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_W);
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.keyRelease(KeyEvent.VK_W);

            Thread.sleep(150);

            r.keyPress(KeyEvent.VK_ALT);
            r.keyPress(KeyEvent.VK_TAB);
            r.keyRelease(KeyEvent.VK_TAB);
            r.keyRelease(KeyEvent.VK_ALT);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
//        if (flag == true) {  // robot 클래스 작동시 키보드 입력 불가 따라서 중단
//            Robot r;
//            try {
//                r = new Robot();
//            } catch (AWTException em) {
//                em.printStackTrace();
//            }
//            switch (e.getKeyCode()) {
//                case KeyEvent.VK_C:
//                    r.keyPress(KeyEvent.VK_F6);
//                    r.keyRelease(KeyEvent.VK_F6);
//                    System.out.println("Flag = " + flag + " inpuc char = " + c);
//                    tmp = r.toString();
//                    System.out.println(tmp);
//            }
//            crowring_bot = null;
//        }
        if (c == 'C' || c == 'c') {
            System.out.println("Flag = " + flag + " inpuc char = " + c);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e);

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public String getString(String tmp) {
        String storage = "";
        for(int i = tmp.length()/2; i<tmp.length(); i++){
            if('0'<=tmp.charAt(i)&&tmp.charAt(i)<='9'){
                storage = storage+tmp.charAt(i);
            }else if(tmp.charAt(i)=='/'){
                storage="";
            }
            else if(tmp.charAt(i)=='#'){
                break;
            }
        }
        return storage;
    }
}

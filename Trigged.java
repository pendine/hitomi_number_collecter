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
    int count = 0;
    private int phazeTime = 50;
    private int copyTime = 50;
    private int KeyReleasedTerm = 50;

    public void trigger_Active() {
//        flag = !flag;
        count++;
        try {
            r = new Robot();
        } catch (AWTException em) {
            em.printStackTrace();
        }

        try {
            Thread.sleep(phazeTime);

            r.keyPress(KeyEvent.VK_ALT);
            r.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(KeyReleasedTerm);
            r.keyRelease(KeyEvent.VK_TAB);
            r.keyRelease(KeyEvent.VK_ALT);

            Thread.sleep(phazeTime);

            r.keyPress(KeyEvent.VK_F6);
            Thread.sleep(KeyReleasedTerm);
            r.keyRelease(KeyEvent.VK_F6);

            Thread.sleep(phazeTime);

            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_C);
            Thread.sleep(KeyReleasedTerm);
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.keyRelease(KeyEvent.VK_C);

//            Thread.sleep(phazeTime);

            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable data = clipboard.getContents(this);
            tmp = (String) data.getTransferData(DataFlavor.stringFlavor);
            String aaa = getString(tmp);
            System.out.print(aaa+" ");
//            new Save_Write_Number().saveNumber(aaa);

//            Thread.sleep(copyTime);

            Thread.sleep(phazeTime);

            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_W);
            Thread.sleep(KeyReleasedTerm);
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.keyRelease(KeyEvent.VK_W);

            Thread.sleep(phazeTime);

            r.keyPress(KeyEvent.VK_ALT);
            r.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(KeyReleasedTerm);
            r.keyRelease(KeyEvent.VK_TAB);
            r.keyRelease(KeyEvent.VK_ALT);

            Thread.sleep(phazeTime);


        } catch (Exception e) {
            e.printStackTrace();
        }
        if(count % 15 == 0){
            System.out.println(" ");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
       if (c == 'C' || c == 'c') {
            System.out.println("  ");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

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

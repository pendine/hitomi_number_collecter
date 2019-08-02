import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;

public class Trigged extends Thread {
    Robot r;
    String[] stringArray;
    int count = 0;
    private int beforeWork = 20;
    private int copyTime = 30;
    private int afterWork = 50;
    private int keyReleasedTerm = 20;

    public String getString(String tmp) {
        String storage = "";
        for (int i = tmp.length() / 2; i < tmp.length(); i++) {
            if ('0' <= tmp.charAt(i) && tmp.charAt(i) <= '9') {
                storage = storage + tmp.charAt(i);
            } else if (tmp.charAt(i) == '/') {
                storage = "";
            } else if (tmp.charAt(i) == '#') {
                break;
            }
        }
        return storage;
    }

    private int numCompare(int checkTimes, int input, int Storage) throws Exception {
        for (int i = 0; i < checkTimes; i++) {
            Thread.sleep(copyTime);
            if (input != Storage) {
                Storage = input;
                System.out.print(Storage + " ");
                if(count%10==0){
                    System.out.println(" ");
                }
                return input;
            }
        }
        return input;
    }
    private int numCompare(int checkTimes, int input, int Storage, JTextArea jta) throws Exception {
        for (int i = 0; i < checkTimes; i++) {
            Thread.sleep(copyTime);
            if (input != Storage) {

                Storage = input;
                jta.append(String.valueOf(Storage)+" ");
                System.out.print(Storage + " ");
                if(count%10==0){
                    System.out.println(" ");
                    jta.append(" \n");
                }
                return input;
            }
        }
        return input;
    }

    public String numCompare(int checkTimes, String input, String Storage, Transferable getText, Clipboard clipboard) throws Exception {
        for (int i = 0; i < checkTimes; i++) {
            if (!input.equals(Storage)) {
                Storage = input;
                System.out.print(Storage + " ");
                return input;
            } else {
                Thread.sleep(copyTime);
                getText = clipboard.getContents(this);
                input = (String) getText.getTransferData(DataFlavor.stringFlavor);
                input = getString(input);
            }
        }
        return input;
    }

    private void insert_to_NumberArray(String[] stringsArray, String newNumber) {
        for (int i = 0; i < stringsArray.length; i++) {
            if (stringArray[i].length() < 5 || stringArray[i].length() > 13) {
                stringsArray[i] = newNumber;
                break;
            }
            if (stringsArray[i].equals(newNumber)) {
                break;
            }
        }
    }

    public void printNumbers() {
        for (int i = 0; i < stringArray.length; i++) {
            System.out.print(stringArray[i] + " ");
            if (i % 15 == 0) {
                System.out.println(" ");
            }
        }
    }

    private void altTab(Robot r, int beforeWaitingTime, int keyWaitingTime, int afterWaitingTime) throws Exception {
        Thread.sleep(beforeWaitingTime);

        r.keyPress(KeyEvent.VK_ALT);
        r.keyPress(KeyEvent.VK_TAB);

        Thread.sleep(keyWaitingTime);

        r.keyRelease(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_ALT);

        Thread.sleep(afterWaitingTime);
    }

    private void funtion6(Robot r, int beforeWaitingTime, int keyWaitingTime, int afterWaitingTime) throws Exception {
        Thread.sleep(beforeWaitingTime);

        r.keyPress(KeyEvent.VK_F6);

        Thread.sleep(keyWaitingTime);

        r.keyRelease(KeyEvent.VK_F6);

        Thread.sleep(afterWaitingTime);
    }

    private void copy(Robot r, int beforeWaitingTime, int keyWaitingTime, int afterWaitingTime) throws Exception {
        Thread.sleep(beforeWaitingTime);

        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_C);

        Thread.sleep(keyWaitingTime);

        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_C);

        Thread.sleep(afterWaitingTime);
    }

    private void closeTab(Robot r, int beforeWaitingTime, int keyWaitingTime, int afterWaitingTime) throws Exception {
        Thread.sleep(beforeWaitingTime);

        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_W);

        Thread.sleep(keyWaitingTime);

        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_W);

        Thread.sleep(afterWaitingTime);
    }

    public void multi_Active(int times){
        int tmp = 0;

        try {
            r = new Robot();
        } catch (AWTException em) {
            em.printStackTrace();
        }
        try {
            altTab(r, beforeWork, keyReleasedTerm, afterWork);

            for(int i=0; i<times; i++) {
                count++;
                funtion6(r, beforeWork, keyReleasedTerm, afterWork);
                copy(r, beforeWork, keyReleasedTerm, afterWork);

                Thread.sleep(copyTime);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                Thread.sleep(copyTime);
                Transferable data = clipboard.getContents(this);
                Thread.sleep(copyTime);
                String aaa = (String) data.getTransferData(DataFlavor.stringFlavor);
                Integer check = Integer.parseInt(getString(aaa));
                if (check == null) {
                    Thread.interrupted();
                }
                Thread.sleep(copyTime);
                int intTemp = Integer.parseInt(getString(aaa));

                Thread.sleep(afterWork);

                tmp = numCompare(copyTime, intTemp, tmp);

                closeTab(r,beforeWork,keyReleasedTerm,afterWork);
            }

            altTab(r, beforeWork, keyReleasedTerm, afterWork);

        } catch (NumberFormatException e){
            System.out.println("\n잘못된 주소 : 중지됨\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void multi_Active(int times, JTextArea jta){
        int tmp = 0;

        try {
            r = new Robot();
        } catch (AWTException em) {
            em.printStackTrace();
        }
        try {
            altTab(r, beforeWork, keyReleasedTerm, afterWork);

            for(int i=0; i<times; i++) {
                count++;
                funtion6(r, beforeWork, keyReleasedTerm, afterWork);
                copy(r, beforeWork, keyReleasedTerm, afterWork);

                Thread.sleep(copyTime);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                Thread.sleep(copyTime);
                Transferable data = clipboard.getContents(this);
                Thread.sleep(copyTime);
                String aaa = (String) data.getTransferData(DataFlavor.stringFlavor);
                Integer check = Integer.parseInt(getString(aaa));
                if (check == null) {
                    Thread.interrupted();
                }
                Thread.sleep(copyTime);
                int intTemp = Integer.parseInt(getString(aaa));

                Thread.sleep(afterWork);

                tmp = numCompare(copyTime, intTemp, tmp, jta);

                closeTab(r,beforeWork,keyReleasedTerm,afterWork);
            }

            altTab(r, beforeWork, keyReleasedTerm, afterWork);

        } catch (NumberFormatException e){
            System.out.println("\n잘못된 주소 : 중지됨\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //class end
}

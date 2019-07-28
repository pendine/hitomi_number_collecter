import java.io.*;

public class Save_Write_Number {
    public void saveNumber(String number) {
        File file = new File("C:\\SaveNumbers.txt");
        String fileLocal = "C:\\SaveNumbers.txt";
        FileWriter writer = null;

        try {
            OutputStream output = new FileOutputStream(fileLocal);
            // BufferedWriter 와 FileWriter를 조합하여 사용 (속도 향상)
            BufferedWriter fw = new BufferedWriter(new FileWriter(fileLocal, true));

            // 파일안에 문자열 쓰기
            fw.write(number);
            fw.flush();

            // 객체 닫기
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

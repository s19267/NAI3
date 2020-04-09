import java.io.*;
import java.util.Scanner;

public class Data {

    int[] info;//0-a,1-b...
    int countLetters;
    String resault;
    int resaultInt;

    public void loadFromFile(String fileName) {
        int[] letters = new int[26];
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName))));
            while (br.ready()) {
                int letter = br.read();
                if (letter < 97)
                    letter += 32;
                if(letter>96 && letter<123) {
                    letters[letter - 97]++;
                    countLetters++;
                }
            }
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        info=letters;
    }

    public void loadFromString(String text){
        int [] letters=new int[26];
        for(int i=0;i<text.length();i++){
            int letter=(int)text.charAt(i);
            if (letter < 97)
                letter += 32;
            if(letter>96 && letter<123) {
                letters[letter - 97]++;
                countLetters++;
            }
            info=letters;
        }

    }

    public int[] getInfo() {
        return info;
    }

    public void setInfo(int[] info) {
        this.info = info;
    }

    public String getResault() {
        return resault;
    }

    public void setResault(String resault) {
        this.resault = resault;
    }

    public int getResaultInt() {
        return resaultInt;
    }

    public void setResaultInt(int resaultInt) {
        this.resaultInt = resaultInt;
    }
}

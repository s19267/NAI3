import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Data> teachData = new ArrayList<Data>();

        loadDatas("Teach/German", teachData, "German", 0, 10);
        loadDatas("Teach/English", teachData, "English", 1, 10);
        loadDatas("Teach/Polish", teachData, "Polish", 2, 10);

        Perceptron german = new Perceptron(0);
        Perceptron english = new Perceptron(1);
        Perceptron polish = new Perceptron(2);
        for (int j = 0; j < 10; j++)
            for (int i = 0; i < 3; i++) {
                english.teach(teachData.get(j + 10 * i));
                german.teach(teachData.get(j + 10 * i));
                polish.teach(teachData.get(j + 10 * i));
            }

        System.out.println("1.test from Test folder\n2.test from input");
        int tmp = scanner.nextInt();
        if (tmp == 1) {
            ArrayList<Data> testData = new ArrayList<Data>();
            loadDatas("Test/English", testData, "English", 0, 3);
            loadDatas("Test/German", testData, "German", 1, 3);
            loadDatas("Test/Polish", testData, "Polish", 2, 3);
            for (Data data : testData) {
                System.out.print(data.resault + " texst, odp: ");
                if (english.calculateY(data) == 1)
                    System.out.print("eng ");
                if (polish.calculateY(data) == 1)
                    System.out.print("pl ");
                if (german.calculateY(data) == 1)
                    System.out.print("ger ");
                System.out.println();
            }
        } else if (tmp == 2) {
            System.out.println("podaj tekst:");
            StringBuilder text = new StringBuilder();
            String line;
            scanner.nextLine();
            while((line=scanner.nextLine()).length()>1){
                text.append(line);
            }
            System.out.println(line);

            Data data = new Data();
            data.loadFromString(text.toString());
            System.out.println("odp: ");
            if (english.calculateY(data) == 1)
                System.out.print("eng ");
            if (polish.calculateY(data) == 1)
                System.out.print("pl ");
            if (german.calculateY(data) == 1)
                System.out.print("ger ");
        }

    }

    public static void loadDatas(String path, ArrayList dataList, String resault, int resaultInt, int count) {
        for (int i = 1; i < count + 1; i++) {
            Data data = new Data();
            data.loadFromFile(path + "/" + i + ".txt");
            data.setResault(resault);
            data.setResaultInt(resaultInt);
            dataList.add(data);
        }
    }
}

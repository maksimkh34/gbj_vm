import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        int WINNINGS_NUMBER = 10;
        Toy t1 = new Toy(1, "конструктор", 2);
        Toy t2 = new Toy(2, "робот", 2);
        Toy t3 = new Toy(3, "кукла", 6);

        Machine machine = new Machine();
        try {
            machine.addToQueue(t1);
            machine.addToQueue(t2);
            machine.addToQueue(t3);
        } catch (Exception e) {
            System.out.println("Error adding toys: " + e.getMessage());
        }

        List<Toy> winnings = new ArrayList<>();
        try {
            machine.staff(WINNINGS_NUMBER);
            winnings = machine.get_winnings();
        } catch (Exception e) {
            System.out.println("Error in machine: " + e.getMessage());
        }

        FileWriter fileWriter = new FileWriter("output.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for(int i = 0; i < WINNINGS_NUMBER; i++) {
            printWriter.print(i+1 + "st win: " + winnings.get(i).name + '\n');
        }
        printWriter.close();
    }
}